package com.kpi.ipk;

import org.omg.PortableServer.POA;

/**
 * Created by andrew_yashin on 1/3/17.
 */
public class InterAbstr extends Abstr{

    public void method(){
        System.out.println("method");
    }



    public static void main(String... args){
        System.out.println("main ");
        getPoint(new InterAbstr());
    }


}

abstract class Abstr {

    abstract public void method();

    public static void getPoint(Abstr point){
        point.method();
        System.out.println("abstr getPoint");
    }
}


