package generics;

import java.io.Serializable;

/**
 * Created by andrew_yashin on 1/17/17.
 */
public interface Task20{
    void f();
    void g();
}

class Task20Class implements Task20{
    public void f() {
        System.out.println("f()");
    }

    public void g() {
        System.out.println("g()");
    }

    public static void gg(){
        System.out.println("Hi");
    }
}

class Task20Class2<T extends Task20>{
    private T obj;
    Task20Class2(T obj) { this.obj = obj; }
    void fg(){
        obj.f();
        obj.g();
    }



    public static void main(String... args){
        new Task20Class2<Task20Class>(new Task20Class()).fg();
    }
}

class Task200 extends Task20Class{
    public static void gg(){

    }
}
