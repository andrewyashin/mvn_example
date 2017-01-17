package test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew_yashin on 1/10/17.
 */
public class Test extends Exception {
    public Test() {
        super("Test");
    }

    public Test(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Test message : " + super.getMessage();
    }

    public static void main(String...args){

        /*try {
            throw new TestException();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }*/
    }
}

class TestException extends Exception{
    @Override
    public String getMessage() {
        return "TestException message : "+ super.getMessage();
    }

    public TestException() {
        super("TestException");
    }

    public TestException(String message) {
        super(message);
    }
}

class Test10{
    void f() {
        try{
            g();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("f()");
        }
    }

    void g() throws Test{
        throw new Test("g()");
    }

    public static void main(String... args){
        new Test10().f();
    }
}

class OnOffSwitch{
    static void f() throws Test{
        throw new Test("f()");
    }
}

class Switch{
    void on(){
        System.out.println("on");
    }
    void off(){
        System.out.println("off");
    }
}

class Lighter{
    static Switch sw = new Switch();
    public static void main(String... args){
        try {
            sw.on();
            throw new NullPointerException();
            //OnOffSwitch.f();
        }
            finally {
            sw.off();
        }
    }
}

class FailingConstructor{

    public static void main(String... args) throws Exception{
        FileInputStream file = new FileInputStream("/Users/andrew_yashin/kpi/mvn_example/src/main/java/test/Task6Class.java");
        System.out.println(file.read());
        file.close();
    }
}



