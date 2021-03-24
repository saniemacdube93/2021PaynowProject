/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

String database_name;
static Connection conn;


public void close_db(){
    try{
         conn.close();
    }catch(Exception ex){
         System.out.println ("DATABASE CONNECTION FAILED \n " + ex.getMessage( ));
    }
}


public void connect_db(){ 
//0. REGISTER MYSQL JDBC DRIVER
   try {
       
       Class.forName("com.mysql.jdbc.Driver").newInstance();

       String url = "jdbc:mysql://127.0.0.1:3306/paynow1";
       String uName = "root";
    // String uPass = "dread_woman";//"dread_woman";
      String uPass = "dread_woman";

       conn = DriverManager.getConnection( url , uName, uPass);
       System.out.println("connected successfully");

   } 
   catch ( Exception err) {
       System.out.println ("DATABASE CONNECTION FAILED \n " + err.getMessage( ));

   }
}

public void update_db(String query){
   try {
       Statement stmt = conn.createStatement();
       stmt.executeUpdate(query);
       System.out.println("Update Successful.");
   } catch (SQLException ex) {
       Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
   }
}

public boolean runQuery(String query){
   try {
      
       Statement stmt = conn.createStatement();
       stmt.executeUpdate(query);
       System.out.println(" Query Run Successful.");
       conn.close();
       return true;
   } catch (SQLException ex) {
       Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       System.out.println("Query Run Failed.");
       return false;
   }

}



public ResultSet select_db(String query){
   try {
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(query);
       System.out.println("Records have been retrieved...");
       return rs; 
   } catch (SQLException ex) {
       Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       return null;
   }
}

 public void insert_db(String query){
        try {
            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
             System.out.println("great inserting............................");
 
      } catch (SQLException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("error inserting............................");
       }

    }


}