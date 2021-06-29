package com.example;

import java.sql.*;
import java.util.Enumeration;

class Main {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch ( ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shades", "shades");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        Enumeration<Driver> e = DriverManager.getDrivers();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}

