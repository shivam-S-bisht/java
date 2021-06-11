package com.example;

class App {

    static int count = 0;

    static synchronized void incr () {
        ++count;
    }

    public static void main (String[] args) throws Exception{


        Thread t1 = new Thread (new Runnable(){
            public void run () {
                for (int i=0; i<10000; i++)
                incr();
            }
        });


        Thread t2 = new Thread (new Runnable(){
           public void run () {
               for (int i=0; i<10000; i++)
               incr();
           } 
        });

        t1.start();
        t2.start();

        // incr();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}