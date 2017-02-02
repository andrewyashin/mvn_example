package io;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrew_yashin on 1/28/17.
 */
public class CountChars {

    public static void main(String... args){
        String filename = "/Users/andrew_yashin/Desktop/Shape.java";

        CharArrayReader in = new CharArrayReader(
                TextFile.read(filename).toCharArray()
        );

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        try {
            int c;
            while ((c = in.read()) != -1){
                if (map.containsKey((char) c)) {
                    map.put((char) c, map.get((char) c).intValue() + 1);
                } else {
                    map.put((char) c, 1);
                }
            }

            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(map);


    }
}
