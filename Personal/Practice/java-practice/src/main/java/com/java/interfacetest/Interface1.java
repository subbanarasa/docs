package com.java.interfacetest;

public interface Interface1 {

    default void test1(){
        System.out.println("Interface1-test1");
    }

    public void m1();
}
