package com.example;

class App {

    public void hello() {

    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {

            public void run () {
                for (int i=0; i<10; i++) {
                    System.out.println("Parent 1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run () {
                for (int i=0; i<10; i++) {
                    System.out.println("Parent 2");
                }
            }
        });

        t1.start();
        t2.start();

    }
}