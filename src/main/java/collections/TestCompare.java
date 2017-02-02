package collections;

import org.jetbrains.annotations.NotNull;
import test.Test;

import java.util.*;

/**
 * Created by andrew_yashin on 1/23/17.
 */
public class TestCompare implements Comparable<TestCompare> {
    Integer integer;

    public TestCompare(Integer integer) {
        this.integer = integer;
    }

    public int compareTo(@NotNull TestCompare o) {
        if (this.integer < o.integer) return -1;
        if (this.integer.equals(o.integer)) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return Integer.toString(this.integer);
    }

    public static void main(String... args){
        Queue<TestCompare> queue = new PriorityQueue<TestCompare>(100);
        Random random = new Random();



    }
}


