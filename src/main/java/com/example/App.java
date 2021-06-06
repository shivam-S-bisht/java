package com.example;

// interface I1 {
//     void show ();
// }


class Parent {
    void show() {
        // something
    }
}

class App {
    public static void main(String[] args) {
        Parent p = new Parent() {
            @Override
            void show() {
                System.out.println("anny show");
            }
        };
        p.show();
        // I1 obj =
    }
}