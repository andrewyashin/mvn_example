package com.kpi.ipk;

class A {
    static {
        System.out.println("static block A");
    }

    static void Sout(){
        System.out.println("method A");
    }

    A(){
        System.out.println("Constructor A");
    }
}

public class Example extends A{

    static {
        System.out.println("static block B");
    }
    Example() {
        System.out.println("Constructor B");
    }

    public static void main(String... args){
        new Example();
    }
}