package io;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrew_yashin on 1/27/17.
 */
public class BufferedInputFile {

    public static String read(String filename){
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = in.readLine()) != null){
                sb.append(s + "\n");
            }

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert in != null;
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }

    public static boolean write(String filename, String text){
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(filename));
            out.write(text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert out != null;
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String... args){
        //System.out.println(read("/Users/andrew_yashin/Desktop/Main.java"));
        System.out.println(write("/Users/andrew_yashin/Desktop/test.txt", "hello\nhello\nhellosfldsfds"));

        String filename, searchWord, filename1;
        LinkedList<String> list = new LinkedList<String>();
        BufferedReader in = null;
        PrintStream out = new PrintStream(System.out);
        PrintWriter outFile = null;

        if(args.length == 1){
            filename = args[0];
            filename1 = args[0];
            searchWord = null;
        } else if (args.length == 2) {
            filename = args[0];
            filename1 = args[0];
            searchWord = args[1];
        } else {
            filename = "/Users/andrew_yashin/Desktop/Main.java";
            filename1 = "/Users/andrew_yashin/Desktop/Example.txt";
            searchWord = null;
        }


        try {
            int count = 1;
            in = new BufferedReader(new FileReader(filename));
            outFile = new PrintWriter(filename1);
            LineNumberReader lineNumberReader = new LineNumberReader(in);
            String s;
            while ((s = in.readLine()) != null){

                if(searchWord != null) {
                    if(s.contains(searchWord))
                    list.add(count++ + s);
                } else {
                    list.add(lineNumberReader.getLineNumber() + " " + s);
                }

                outFile.println(lineNumberReader.getLineNumber() + " " + s);


                //out.append(s.toUpperCase() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert in != null;
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String s: list){
            System.out.println(s);
        }

//        StringReader stringReader = new StringReader(BufferedInputFile.read("/Users/andrew_yashin/Desktop/Main.java"));
//        int c;
//        try {
//            while ((c = stringReader.read()) != -1){
//                System.out.println((char)c);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            DataInputStream dataInputStream = new DataInputStream(
//                    new ByteArrayInputStream(
//                            BufferedInputFile.read("/Users/andrew_yashin/Desktop/Main.java").getBytes()));
//
//            while (true) {
//                System.out.println(dataInputStream.readByte());
//            }
//        } catch (EOFException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }
}
