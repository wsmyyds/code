package com.company;

public class Main {

    float f = 1.0f;
    Float F = 1f;
    public static void main(String[] args) {
        // write your code here
        //System.out.println(t());
        //t2();


        Main m = new Main();
        m.f = 197;


    }

    public static void t2(){
        int i = 1;
        int k = 0;
        int j = i++;
        i=1;
        k = j+(++i)*i++;
        System.out.printf(k+" "+i+" "+j);
    }

    public static String t() {
        String str = "";
        try {
            str = "try";
            System.out.println(10/0);
            return str;
        } catch (Exception e) {
            str = "catch";
            return str;
        } finally {
            str = "finally";
            System.out.println("zx-finally");
            return str;
        }
    }
}
