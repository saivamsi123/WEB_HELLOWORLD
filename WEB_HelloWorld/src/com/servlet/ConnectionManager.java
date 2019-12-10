package com.servlet;

 import java.sql.*;
 import java.util.*;


   public class ConnectionManager {

      static Connection con;
      static String url;
      public ConnectionManager()
      {
    	  String dbDriver = "com.mysql.cj.jdbc.Driver";
          String dbUrl = "jdbc:mysql://localhost:3306/Allianz?serverTimezone=" + TimeZone.getDefault().getID();
          String dbUsername = "root";
          String dbPassword = "";
          try {
              Class.forName(dbDriver);
              con = DriverManager.getConnection(dbUrl, dbUsername,
                      dbPassword);

          } catch (Exception e) {
              System.out.println(e);
          }
      }
      
            
      public static Connection getConnection() {
          return con;
      }

   }