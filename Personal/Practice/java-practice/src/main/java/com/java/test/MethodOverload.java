package com.java.test;

public class MethodOverload {


    public static void main(String[] args) {
        m1(null);
    }

   /* static void m1(Integer str){
        System.out.println("m1-Integer");

    }*/

   static void m1(String str){
        System.out.println("m1-string");

    }
    static void m1(Object str){
        System.out.println("m1-object");

    }



}
