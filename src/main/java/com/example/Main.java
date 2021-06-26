package com.example;

import java.sql.*;
import java.util.Enumeration;

class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch ( ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        Enumeration<Driver> e = DriverManager.getDrivers();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}