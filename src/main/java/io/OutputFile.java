package io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by andrew_yashin on 1/28/17.
 */
public class OutputFile {

    public static void main(String... args){
        String filenameIN = "/Users/andrew_yashin/Desktop/Shape.java",
               filenameOUT = "/Users/andrew_yashin/Desktop/Example.txt";

        DataInputStream inNOTBuffer = null;
        BufferedReader inBuffer = null;

        long date1 = new Date().getTime() * 1000;

        try{
            inNOTBuffer = new DataInputStream(new FileInputStream(filenameIN));
            String s;

            while ( ( s = inNOTBuffer.readLine()) != null){
                //System.out.println(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                assert inNOTBuffer != null;
                inNOTBuffer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        long date11 = new Date().getTime() * 1000;

        long date2 = new Date().getTime() * 1000;

        try{
            inBuffer = new BufferedReader(new FileReader(filenameIN));
            String s;

            while ( (s = inBuffer.readLine()) != null){
                //System.out.println(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                assert inBuffer != null;
                inBuffer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        long date22 = new Date().getTime() * 1000;

        System.out.println("\n\n\n NOT BUFFER = " + (date11 - date1));
        System.out.println("\n\n\n BUFFER = " + (date22 - date2));

        BufferedReader in = null;
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        try{
            in = new BufferedReader(
                    new FileReader(filenameIN));
            outputStream = new DataOutputStream(
                    new FileOutputStream(filenameOUT));
            inputStream = new DataInputStream(
                    new FileInputStream(filenameOUT));


            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = in.readLine()) != null){
                sb.append(s);
                sb.append("\n");
            }

            /*outputStream.writeUTF(sb.toString());*/
            outputStream.writeDouble(45.56d);
            outputStream.writeDouble(45.5666d);
            outputStream.writeInt(45);
            outputStream.writeDouble(45.5666d);
            outputStream.writeInt(46);

            System.out.println(inputStream.readDouble());
            System.out.println(inputStream.readDouble());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readDouble());
            System.out.println(inputStream.readInt());

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                assert in != null;
                assert outputStream != null;

                in.close();
                outputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }


        RandomAccessFile rf = null;
        Random rand  = new Random();
        String randFile = "/Users/andrew_yashin/Desktop/RandomAccessTest.txt";

        try{
            rf = new RandomAccessFile(randFile, "rw");
            for (int i = 0; i < 10; i++){
                int nextInt = rand.nextInt();
                rf.writeInt(nextInt);
                System.out.println(i + ": " + nextInt);
            }
            rf.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            rf = new RandomAccessFile(randFile, "r");
            rf.seek(6*4);
            System.out.println(6 + ": " + rf.readInt());
            rf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }




}
