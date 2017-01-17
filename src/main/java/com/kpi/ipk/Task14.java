package com.kpi.ipk;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by andrew_yashin on 1/4/17.
 */
interface Interface{
    int HELLO = 5;

}
class RandomCharGenerator {
    Random random = new Random();

    private static final char[] capitals =
            "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
    private static final char[] lowers =
            "QWERTYUIOPASDFGHJKLZXCVBNM"
                    .toLowerCase()
                    .toCharArray();
    private static final char[] vowels =
            "aeyuio".toCharArray();

    public char getRandomChar() {
        switch (random.nextInt(2)) {
            case 0:
                return capitals[random.nextInt(capitals.length)];
            default:
                return lowers[random.nextInt(lowers.length)];
        }
    }

    public String getRandomCharArray(int size){
        StringBuilder stringBuilder = new StringBuilder(size);
        for (int i = 0; i < size; i++){
            stringBuilder.append(getRandomChar());
        }

        return stringBuilder.toString();
    }
}
public class Task14 implements Readable{
    private Random random = new Random(40);
    private int count;


    public Task14(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0)
            return -1;

        cb.append(new RandomCharGenerator().getRandomCharArray(10));

        cb.append('\n');
        return 11;
    }

    public static void main(String... args){
        Scanner scanner = new Scanner(new Task14(20));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        System.out.println(Interface.HELLO);
    }
}

