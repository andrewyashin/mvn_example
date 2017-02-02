package io;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by andrew_yashin on 1/26/17.
 */
public class DirList {
    public static void main(String... args){
        String pattern = ".*";

        File file = new File(".");
        File[] files = file.listFiles(new DirFilter(pattern));

        long size = 0;
        if(files != null){
            for (File file1: files){
                System.out.println(new Date(file1.lastModified()));
            }
        }

        System.out.println(size);


    }

    static class DirFilter implements FilenameFilter{
        private Pattern pattern;

        public DirFilter(String pattern) {
            this.pattern = Pattern.compile(pattern);
        }

        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}

class SortedDirList{

    public static void main(String... args){
        if(args.length == 1){
            for(String file: list(args[0])){
                System.out.println(file);
            }
        } else if (args.length == 2){
            for (String file: list(args[0], args[1])){
                System.out.println(file);
            }
        } else {
            System.out.println("Bad bad bad");
        }
    }

    public static String[] list(String address){
        File file = new File(address);
        return file.list();
    }

    public static String[] list(String adress, final String regex){
        File file = new File(adress);

        return file.list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }
}
