package com.java.interfacetest;

public interface Interface2 {

    default void test1(){
        System.out.println("Interface2-test1");
    }

    public void m1();
}
