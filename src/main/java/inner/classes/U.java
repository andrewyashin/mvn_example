package inner.classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrew_yashin on 1/5/17.
 */

public interface U {
    void printMes();
    int getId();
    double getDouble();
}

class A {
    int i = 0;
    double d = 0.0;

    public A(int i, double d) {
        this.i = i;
        this.d = d;
    }

    U getU(){
        return new U() {
            public void printMes() {
                System.out.println("HEllo");
            }

            public int getId() {
                return i;
            }

            public double getDouble() {
                return d;
            }
        };
    }
}


class B {
    static int i = 0;
    U[] array;
    int size = 0;

    public B(int size) {
        array = new U[size];
        this.size = size;
    }

    void putU(U item) {
        array[i++] = item;
    }

    void clearU(int index) {
        if (index < size && index >= 0) {
            array[index] = null;
        }
    }

    void callU() {
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                System.out.println("\n  --- NULL ---  \n");
            } else {
                array[i].printMes();
                System.out.println(array[i].getId() + " -- ID ");
                System.out.println(array[i].getDouble() + " -- DOUBLE ");
            }
        }
    }
}

class Main {

    private interface Main3{
        void getId();
    }



    public static void main(String... args) throws Exception{
        A a1 = new A(1,2);
        A a2 = new A(2,3);
        A a3 = new A(4,5);
        A a4 = new A(6,7);

        B b = new B(4);

        b.putU(a1.getU());
        b.putU(a2.getU());
        b.putU(a3.getU());
        b.putU(a4.getU());

        b.clearU(2);
        b.callU();

        List<String> list = new ArrayList<String>();

        list = new LinkedList<String>();

        Main3 main3 = new Main3() {
            public void getId() {
                System.out.println("ID");
            }
        };

        Main3 main31 = main3.getClass().newInstance();

        main31.getId();


    }
}

