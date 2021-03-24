/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;

import PaymentGateway.Model.DatabaseNav;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JungleApps
 */
public class FindStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
       
        String StudentId= request.getParameter("studentId").toUpperCase();
        try {
        // Find Old Students from Nav
        DatabaseNav connectDb = new DatabaseNav();
        String selectQueryNav ="SELECT * FROM [NUST2017].[dbo].[NUST_USD$Customer] WHERE [No_]='"+StudentId+"'";
        ResultSet rs1= connectDb.select_db(selectQueryNav);
                                                                                                                                              
            if(rs1.next() && rs1.getString("Citizenship").equalsIgnoreCase("ZW")){
               //Found Student, now redirect to Paynow
               
            FindDAO findDAO =new FindDAO();
            List<Find> find = findDAO.listStudent(StudentId);
            request.setAttribute("StudentDetails", find);
            request.getRequestDispatcher("/payNowInitiate1.jsp").forward(request, response); 
            }
          
            else{
           //Find New Students on Nav 
            DatabaseNav connectDb2 = new DatabaseNav();
            String selectQueryNav2 ="SELECT * FROM [NUST2017].[dbo].[NUST_USD$Applicant] WHERE [Customer No_]='"+StudentId+"'";
            ResultSet rs2= connectDb2.select_db(selectQueryNav2);
            if(rs2.next()&& rs1.getString("Citizenship").equalsIgnoreCase("ZW")){
             //Found Applicant, now redirect to Paynow
            FindDAO findDAO =new FindDAO();
            List<Find> find = findDAO.listApplicant(StudentId);
            request.setAttribute("StudentDetails", find);
             request.getRequestDispatcher("/payNowInitiate1.jsp").forward(request, response); 
            }
            
            
            
            
            else{
            request.getRequestDispatcher("/studNotFound.jsp").forward(request, response);
            
            }
            
            }
                
                
        } catch (IOException ex) {
            request.getRequestDispatcher("/networkErr.jsp").forward(request, response);
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/networkErr.jsp").forward(request, response);
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            request.getRequestDispatcher("/networkErr.jsp").forward(request, response);
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String StudentId= request.getParameter("studentId").toUpperCase();
        try {
        // Find Old Students from Nav
        DatabaseNav connectDb = new DatabaseNav();
        String selectQueryNav ="SELECT * FROM [NUST2017].[dbo].[NUST_USD$Customer] WHERE [No_]='"+StudentId+"'";
        ResultSet rs1= connectDb.select_db(selectQueryNav);
                                                                                                                                              
            if(rs1.next()&& rs1.getString("Citizenship").equalsIgnoreCase("ZW")){
               //Found Student, now redirect to Paynow
               
            FindDAO findDAO =new FindDAO();
            List<Find> find = findDAO.listStudent(StudentId);
            request.setAttribute("StudentDetails", find);
            request.getRequestDispatcher("/payNowInitiate1.jsp").forward(request, response); 
            }
            
            
            
            
            else{
           //Find New Students on Nav 
            DatabaseNav connectDb2 = new DatabaseNav();
            String selectQueryNav2 ="SELECT * FROM [NUST2017].[dbo].[NUST_USD$Applicant] WHERE [Customer No_]='"+StudentId+"'";
            ResultSet rs2= connectDb2.select_db(selectQueryNav2);
            if(rs2.next() &&rs2.getString("Citizenship").equalsIgnoreCase("ZW")){
             //Found Applicant, now redirect to Paynow
            FindDAO findDAO =new FindDAO();
            List<Find> find = findDAO.listApplicant(StudentId);
            request.setAttribute("StudentDetails", find);
             request.getRequestDispatcher("/payNowInitiate1.jsp").forward(request, response); 
            }
            
            
            
            
            else{
            request.getRequestDispatcher("/studNotFound.jsp").forward(request, response);
            
            }
            
            }
                
                
        } catch (IOException ex) {
            request.getRequestDispatcher("/networkErr.jsp").forward(request, response);
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/networkErr.jsp").forward(request, response);
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            request.getRequestDispatcher("/networkErr.jsp").forward(request, response);
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FindStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
