package com.example;

import java.io.*;
import java.util.*;

class App {

    static class GenericTree implements Iterable<Integer> {
        Node root;

        GenericTree (Node root) {
            this.root = root;
        }
        
        public Iterator<Integer> iterator () {
            Iterator<Integer> it = new GenericTreeIterator(root);
            return it;
        }
    }


    static class GenericTreeIterator implements Iterator<Integer> {

        Integer nval;
        Stack<Pair> st;

        GenericTreeIterator (Node root) {
            this.st = new Stack<>();
            st.add(new Pair(root, -1));
            next();
        }

        public boolean hasNext () {
            if (nval == null) {
                return false;
            } else {
                return true;
            }
        }

        public Integer next () {
            Integer fr = 0;
            nval = null;

            while (st.size()!=0) {
                Pair top = st.peek();
                if (top.state == -1) {
                    nval = top.node.data;
                    ++top.state;
                    break;
                } else if (top.state == top.node.children.size()) {
                    st.pop();
                } else {
                    st.push(new Pair(top.node.children.get(top.state), -1));
                    ++top.state;
                }
            }
            return fr;
        }

    }

    static class Pair {
        Node node;
        int state;

        Pair (Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        GenericTree gt = new GenericTree(root);

        for (int val: gt) {
            System.out.println(val);
        }
    }
}