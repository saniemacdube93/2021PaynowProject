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
//import org.springframework.orm.jpa.vendor.Database;

//import static students.portal.model.Database.conn;

/**
 *
 * @author mnyoni
 */
public class DatabaseNav {
      String database_name;
    static Connection conn;
    
    public DatabaseNav(){
        connect_db();
    }
    
    public static void main(String []args){       
       DatabaseNav db1 = new DatabaseNav();
       DatabaseNav.connect_db();
       
   }
    
    
    public static  void connect_db(){      
        //0. REGISTER MYSQL JDBC DRIVER
        try {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
       
           String url1 = "jdbc:sqlserver://196.220.119.10:1433;databaseName=NUST2017";
           // String url1 = "jdbc:sqlserver://196.220.119.58:1433;databaseName=Test_NUST2017";
            //String uName1 = "umgaga";
            String uName1 = "software";
            String uPass1 = "Monday2@nust.ac.zw";
            //String uPass1 = "Mdaka@nust.ac.zw";		
            conn = DriverManager.getConnection( url1 , uName1, uPass1);
            System.out.println("connected successfully to NAV test database by Musa");
					   
	 }	 
	 catch ( ClassNotFoundException err) {
	    System.out.println ( err.getMessage( ));
	
	} catch (IllegalAccessException err) {
            System.out.println ( err.getMessage( ));
          } catch (InstantiationException err) {
              System.out.println ( err.getMessage( ));
          } catch (SQLException err) {
              System.out.println ( err.getMessage( ));
          }
    }
    
    public void update_db(String query){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Updated records into the table on NUMBER SERIES...");
        } catch (SQLException ex) {
           Logger.getLogger(DatabaseNav.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void insert_db(String query){
        try {
            System.out.println("Creating statement........................"); 
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            
            System.out.println("Inserted records into the table...................");  
      } catch (SQLException ex) {
           Logger.getLogger(DatabaseNav.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("error inserting............................");
       }

    }

    public void delete (String query){
         try {
              Statement stmt = conn.createStatement();
              stmt.executeUpdate(query);
              
             System.out.println("Records have been deleted...............");
             conn.close();
      } catch (SQLException ex) {
           Logger.getLogger(DatabaseNav.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
    
     public ResultSet select_db(String query){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Records have been retrieved.....................");
              //conn.close();
            return rs; 
              //conn.close();
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseNav.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
     
      public ResultSet select_dbR(String query){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Records have been retrieved.....................");
            return rs; 
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseNav.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
     
     public void close_db() throws SQLException{
         conn.close();
     }
   //conn.close() 
     
     public boolean runQuery(String query){
    try {
        
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println(" Query Run Successful.....................");
        conn.close();
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(DatabaseNav.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Query Run Failed.........................");
        return false;
    }

}
}