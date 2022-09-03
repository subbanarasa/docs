package com.java.interfacetest;

public class InterfaceImpl implements Interface1, Interface2{

    @Override
    public void test1() {
        Interface2.super.test1();
    }

    @Override
    public void m1() {
        System.out.println("m1");
    }


    public static void main(String[] args) {
        InterfaceImpl im = new InterfaceImpl();
        im.m1();
    }
}
