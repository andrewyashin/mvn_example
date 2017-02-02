package io;

import java.io.*;
import java.util.Random;

/**
 * Created by andrew_yashin on 1/30/17.
 */
public class TrySerialization {

    private static class Data implements Serializable{
        private int i;
        Random random;

        public Data(){
            random = new Random();
            this.i = random.nextInt();
        }
        public Data(int i){
            this.i = i;
        }

        public int getI(){
            return this.i;
        }

        @Override
        public String toString() {
            return Integer.toString(i) + " ";
        }
    }

    public static void main(String... args) {
        putData();
        getData();
    }

    public static boolean putData(){
        boolean ind = false;
        try{
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("test.out"));

            Data data1 = new Data(1);
            Data data2 = new Data(2);
            Data data3 = new Data(3);
            Data data4 = new Data(4);

            out.writeObject(data1);
            out.writeObject(data2);
            out.writeObject(data3);
            out.writeObject(data4);

            out.close();
            ind = true;
        } catch (IOException e){
            e.printStackTrace();
        }

        return ind;
    }

    public static void getData(){
        try{
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("test.out"));

            System.out.println(in.readObject());

            in.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
