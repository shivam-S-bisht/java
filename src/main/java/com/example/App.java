package com.example;

import java.io.*;
import java.util.*;

class App {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {

        String str = node.data + "->";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        for (Node child : node.children) {
            if (find(child, data)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath (Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(data);
            return bres;
        }

        for (Node child: node.children) {
            ArrayList<Integer> mres = nodeToRootPath(child, data);
            if (mres.size()!=0) {
                mres.add(node.data);
                return mres;
            }
        }

        ArrayList<Integer> mres = new ArrayList<>();
        return mres;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        sc.close();
        
        Node root = construct(arr);
        System.out.println(find(root, data));
        System.out.println(nodeToRootPath(root, data));

    }
}