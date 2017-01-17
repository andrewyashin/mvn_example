package rtti;


import inner.classes.Array;
import sun.security.provider.SHA;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrew_yashin on 1/15/17.
 */
interface Inter1{};
interface Inter2{};
interface Inter3{};
interface Inter4{};

class Toy{
    int i;

    Toy(){}

    Toy(int i) {
        this.i = i;
    }
}

class FancyToy extends Toy
implements Inter1,Inter2, Inter3, Inter4{
    FancyToy(){super();}
    FancyToy(int i){
        super(i);
    }
}


public class ToyTest {

    public static void main(String[] args){
        Class cc = null;
        try{
            cc = Class.forName("rtti.FancyToy");

        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Class Not Found");
            System.exit(1);

        }

        System.out.println(cc.getSimpleName());
        System.out.println(cc.getCanonicalName());
        Class[] classesArray = cc.getClasses();
        for (Class clas: classesArray){
            System.out.println(clas);
        }

        Class[] array = cc.getInterfaces();
        for (Class cl: array){
            System.out.println(cl);
        }

        Class fancyToyClass = Toy.class;

        Toy obj = null;
        try {
            obj = (Toy) fancyToyClass.getConstructor(new Class[] {int.class}).newInstance(1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(obj.i);



    }

    public static Circle newCircle(){
        return new Circle();
    }

}

class Shape{
    private int i = 0;

    void draw(){
        System.out.println(getClass().getSimpleName() + ".class");
    }
}

class Circle extends Shape{
    private int i = 0;

    void draw(){
        System.out.println(getClass().getSimpleName() + ".class");
    }
}

class Circle2 extends Circle{

    void print(){
        System.out.println("Hi, I'm circle2");
    }

    public static void main(String[] args){
        List<Shape> shapes = new ArrayList<Shape>(Arrays.asList(
                new Circle(), new Romboid(), new Triangle()
        ));

        for (Shape shape: shapes){
            shape.draw();
        }

        Circle circle = new Circle();
        Circle circle1 = (Circle) new Shape();

    }
}
class Romboid extends Shape{
    void draw(){
        System.out.println("Romboid");

        class Hi{

        }
    }
}
class Triangle extends Shape{}





