package com.example;

class App {

    public void hello() {

    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Parent 1");
                }
            }
        };

        Runnable r2 = new Runnable() {

            public void run () {
                for (int i=0; i<10; i++) {

                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}