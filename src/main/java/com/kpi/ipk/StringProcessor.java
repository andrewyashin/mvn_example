package com.kpi.ipk;

import java.util.Arrays;

/**
 * Created by andrew_yashin on 1/3/17.
 */
interface Processor{
    String getName();
    Object process(Object input);
}

class Apply{
    static void process(String s, Processor obj){
        System.out.println("Processor name - " + obj.getName());
        System.out.println(obj.process(s));
    }
}
public abstract class StringProcessor implements Processor{
    public String getName(){
        return this.getClass().getName();
    }

    private static String string = "If she need this, take this";

    abstract public Object process(Object input);

    public static void main(String... args){
        Apply.process(string, new UpCase());
        Apply.process(string, new LowerCase());
        Apply.process(string, new ArrayCase());
    }
}

class UpCase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LowerCase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class ArrayCase extends StringProcessor{
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

interface Inter1{}

interface Inter2 extends Inter1{}

interface Inter3 extends Inter1{}

interface Inter4 extends Inter2, Inter3{}