package com.example;

class App {

    static class Parent1 extends Thread {
        void show() {
            for (int i=0; i<10; i++)
            System.out.println("Parent 1");
        }

        public void run() {
            show();
        }
    }

    static class Parent2 extends Thread {
        void show() {
            for (int i=0; i<10; i++)

            System.out.println("Parent 2");
        }

        public void run() {
            show();
        }
    }

    public void hello () {

    }

    public static void main(String[] args) {

        Parent1 p1 = new Parent1();
        Parent2 p2 = new Parent2();

        // Thread t1 = new Thread(p1);
        // Thread t2 = new Thread(p2);

        p1.start();
        p2.start();

        

    }
}