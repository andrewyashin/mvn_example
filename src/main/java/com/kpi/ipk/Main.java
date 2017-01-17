package com.kpi.ipk;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Main{
    enum Money{
        Dollar, UAH, EURO, KZ, RUB
    }

    public Main(){
        System.out.println("hihihi");
    }


    protected String string = "String";

    public Main(String string){
        System.out.println(string);
    }

    public static void main(String[] args) {

//        new Main().task19_3("hi1", "h2...");
//        new Main().task19_3(new String[]{"h1[]", "h22[]"});

        for (Money money: Money.values()){
            System.out.println(money + " ,"+  money.ordinal());
        }


    }

    private void runFibonachi(String... args){
        int prev = 1, prev1 = 1;
        System.out.println(Integer.parseInt(args[0]));

        for (int i = 0; i < Integer.parseInt(args[0]); i++){
            if (i==0 || i==1){
                System.out.print(prev + ", ");
            } else{
                int result = prev1+ prev;
                System.out.print(result + ", ");
                prev1 = prev;
                prev = result;
            }
        }
    }

    private void getVampire(Integer number){
        if (number.toString().length() % 2 == 0){

        }
    }

    private void task16_1(){
        String[] array = {"1" , "2", "4" , "5"};

        for (String item : array){
            System.out.println(item);
        }

    }

    public void task17_2(){
        Main[] array = new Main[5];

        for (int i = 0; i < 5; i++){
            array[i] = new Main(Integer.toString(i));
        }

    }

    private void task19_3(String ...  args){
        for (String string: args){
            System.out.println(string + " " + string.getClass() + "@" + string.hashCode());
        }
    }
}
