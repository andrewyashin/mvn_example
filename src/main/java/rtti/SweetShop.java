package rtti;

import abs.intr.Main;
import com.kpi.ipk.Task14;
import ipk2.Main2;
import strings.Replace;
import strings.Test;
import sun.security.provider.SHA;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew_yashin on 1/16/17.
 */
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        for (String arg: args){
            try{
                Class.forName("rtti." + arg);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        try {
            Class cc = Class.forName("rtti.Candy");
            Candy candy = (Candy) cc.newInstance();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        getClasses(new Task14(5));

        char[] chars = {'c', 'v'};

    }

    public static <T> void getClasses(T object){
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields){
            System.out.println(field.getName());
        }
    }


}

class CountedIntegers{
    static int count = 0;
    @Override
    public String toString() {
        count++;
        return Integer.toString(count);
    }
}


class Add<T>{
    private Class<T> type;

    public Add(Class<T> type) {
        this.type = type;
    }

    public Add(){
        System.out.println("Add");
    }
    public void createList(int countElements){
        List<T> list = new ArrayList<T>();
        try {
            for (int i = 0; i < countElements; i++) {
                list.add(type.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        System.out.println(list);
    }

    public static void main(String[] args){
        Add<CountedIntegers> add = new Add<CountedIntegers>(CountedIntegers.class);
        add.createList(10);

        try {
            System.out.println(Add.class.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        try {
            Class<?> classMain2 = Class.forName("ipk2.Main2");
            Method[] methods = classMain2.getDeclaredMethods();
            Constructor[] constructors = classMain2.getDeclaredConstructors();
            Field[] fields = classMain2.getDeclaredFields();

            System.out.println("----- Methods: ");
            for (Method method: methods){
                System.out.println(method);
            }


            System.out.println("----- Fields: ");
            for (Field field: fields){
                field.setAccessible(true);



                System.out.println(field + " = " + field.get(new Main2()));
            }


            System.out.println("----- Constructors: ");
            for (Constructor constructor: constructors){
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
