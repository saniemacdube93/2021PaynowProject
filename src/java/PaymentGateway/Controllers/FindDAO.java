/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;

import PaymentGateway.Model.DatabaseNav;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JungleApps
 */
public class FindDAO {
    
    
     public List<Find> listStudent(String studId) throws SQLException, ClassNotFoundException, InstantiationException, ParseException {
        List<Find> students = new ArrayList<Find>();
        String StudentId =studId;
     try{ 
            /*******************CODE FOR SELECT FROM SQL FOR OLD STUDENTS STARTS HERE******************************************/
          DatabaseNav connectDb = new DatabaseNav();
          String selectQueryNav ="SELECT * FROM [NUST2017].[dbo].[NUST_USD$Customer] WHERE [No_]='"+StudentId+"'";
          ResultSet rs1= connectDb.select_db(selectQueryNav);
           // System.out.println("Records have been retrieved.....................");
            if (rs1.next()){
                Find find= new Find();
                find.setStudentNumber(rs1.getString("No_"));
                find.setStudName(rs1.getString("Name 2"));
                find.setStudSurname(rs1.getString("Name"));
                find.setStudProg(rs1.getString("Class Code"));
                find.setCitizenship(rs1.getString("Citizenship"));
                //find.setStudProg(rs1.getString("PROGRAM_NAME"));
                
               
                 students.add(find);
                 System.out.println(" returning result set for  students...from sql");
                /*******************CODE FOR SELECT FROM SQL FOR OLD STUDENTS ENDS HERE******************************************/
            }
           
        }
       catch(SQLException e){}
        return students;
 }
     
     
public List<Find> listApplicant(String studId) throws SQLException, ClassNotFoundException, InstantiationException, ParseException {
        List<Find> students = new ArrayList<Find>();
        String StudentId =studId;
    
       try{ 
            /*******************CODE FOR SELECT FROM SQL FOR APPLICANTS STARTS HERE******************************************/
           DatabaseNav connectDb2 = new DatabaseNav();
            String selectQueryNav2 ="SELECT  * FROM [NUST2017].[dbo].[NUST_USD$Applicant] WHERE [Customer No_]='"+StudentId+"'";
            ResultSet rs2= connectDb2.select_db(selectQueryNav2);
           // System.out.println("Records have been retrieved.....................");
            if (rs2.next()){
                Find find2= new Find();
                find2.setStudentNumber(rs2.getString("Customer No_"));
                find2.setStudName(rs2.getString("Forenames"));
                find2.setStudSurname(rs2.getString("Surname"));
                find2.setStudProg(rs2.getString("Selected Programme"));
                
               
                 students.add(find2);
                 System.out.println(" returning result set for  applicants...from sql");
                /*******************CODE FOR SELECT FROM SQL FOR APPLICANTS ENDS HERE******************************************/
            }
     
        }
       catch(SQLException e){
       }
       System.out.println(" Returning ResultSet for Personal Details Data Access Object*******************************************");
        return students;


}
    
}
    

