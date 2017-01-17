package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrew_yashin on 1/10/17.
 */
public class Unsupported {
    public static void main(String... args){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        try{
            list.add(1);
        } catch (Exception e){
            System.out.println("add : " + e);
        }

        try {
            list.addAll(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        } catch (Exception e){
            System.out.println("addAll : " + e);
        }

        try{
            list.clear();
        } catch (Exception e){
            System.out.println("clear : " + e);
        }

        System.out.println(list);


    }
}

