package com.example;

import java.security.spec.DSAGenParameterSpec;
import java.util.*;

class App {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    //
    public static Node construct(int[] arr, int size) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> h = new ArrayDeque<>();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node();
            node.data = arr[i];
            if (q.size() == 0) {
                root = node;
                q.add(root);
            } else {
                if (q.peek().children.size() == 3) {
                    q.remove();
                    if (q.size() == 0) {
                        q = h;
                        h = new ArrayDeque<>();
                    }
                }
                q.peek().children.add(node);
                h.add(node);
            }
        }

        return root;

    }

    public static void display(Node node) {
        String str = node.data + "->";
        for (Node child : node.children) {
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        display(construct(arr, 3));

    }
}