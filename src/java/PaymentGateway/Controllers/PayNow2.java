/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.SQLException; 
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import PaymentGateway.Model.PayNowInitiate1;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.mail.MessagingException;
//import StudentApplicationReg.Model.ModelMail;
import PaymentGateway.Model.SHA512;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.lang.String;
//import StudentApplicationReg.Controllers.PersonalDetails;
/**
 *
 * @author Musa
 */
public class PayNow2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
196     */
   
    static Connection conn;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String studId = request.getParameter("studNumber").trim();
            String mobile = request.getParameter("telephone").trim();
            String email = request.getParameter("email").trim();
            Double amount =Double.parseDouble(request.getParameter("amount").trim());
            
            System.out.println("this is the user in PayNow controller\n"+studId);
            session.setAttribute("StudId", studId);
     try{             
 
        //SHA512 sh = new SHA512();      
             
        
        //String hashCode = sh.getPaymentInfo(amount, studId, email, mobile);
         // String hashCode= sh.getPaymentInfo(amount, email, email, mobile)
        PayNowInitiate1 p = new PayNowInitiate1();
        String test4 = p.sendPost1(studId, amount, mobile, email);
        System.out.println("LAMUHLA AABANTU BALOBUTONGO" +test4);
        //response.sendRedirect("https://www.paynow.co.zw/Payment/ConfirmPayment/1002744/kitso.noko@hotmail.com/-/");
        response.sendRedirect(test4.trim());
       
        } catch (Exception ex) {
            Logger.getLogger(PayNow2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
           