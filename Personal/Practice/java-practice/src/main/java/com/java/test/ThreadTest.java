package com.java.test;

public class ThreadTest {

    private Integer number = 1;

    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest.printOdd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadTest.printEven();;
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void printOdd() {

        synchronized (this) {
            while (true) {
                if (number > 10) {
                    break;
                }
                System.out.println("printOdd::"+number);
                while (number % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(number);
                number++;


                notify();
            }
        }
    }

    private void printEven() {

        synchronized (this) {
            while (true) {
                if (number > 10) {
                    break;
                }
                System.out.println("printEven::"+number);
                while (number % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(number);

                number++;
                notify();
            }
        }
    }


}
