/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
//import java.lang.Integer;
import PaymentGateway.Model.DatabaseNav;
import PaymentGateway.Model.SHA512;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Listener extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String googleAnalytics = "<!-- Global site tag (gtag.js) - Google Analytics -->";
        googleAnalytics = googleAnalytics + "<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-115633001-2\"></script>";
        googleAnalytics = googleAnalytics + "<script>";            
        googleAnalytics = googleAnalytics + "window.dataLayer = window.dataLayer || [];";
        googleAnalytics = googleAnalytics + "function gtag(){dataLayer.push(arguments);}";
        googleAnalytics = googleAnalytics + "gtag('js', new Date());";
        googleAnalytics = googleAnalytics + "gtag('config', 'UA-115633001-2');";
        googleAnalytics = googleAnalytics + "</script>";
        
        //New coded added by HT 08 July 2018
        String recID = request.getParameter("id");
        PaynowPoller paynowPoller = new PaynowPoller();
        try {
            paynowPoller.pollPaynow(Integer.parseInt(recID));
        } catch (Exception ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }            
            
            
            
            
//        // Commented out by HT 08 July 2018
//        String ref = request.getParameter("reference");
//        String paynownumber = request.getParameter("paynowreference");
//        String amnt = request.getParameter("amount");
//        String stat = request.getParameter("status");
//        String coded = request.getParameter("hash");
//        String recID = request.getParameter("id");
//        String pollUrlValueX = request.getParameter("pollurl");
//
//       // String merchant_keyX ="1747d3b9-27ad-4ae3-ba1c-13557544b62f";
//        String merchant_keyX ="7b57815a-b2e7-47ae-a57a-cb3044d5850d";//Live deployment
//
//        String referenceX = request.getParameter("reference");
//        String statusX = request.getParameter("status");
//        String amountX = request.getParameter("amount");
//        String paynowReferenceX = request.getParameter("paynowreference");        
//
//        SHA512 cash = new SHA512();
//
//        String password1 =  referenceX+ paynowReferenceX + amountX + statusX + pollUrlValueX + merchant_keyX;
//
//             String validHash = cash.passHash(password1);
//            DailyJob g = new DailyJob();
//            String strDate = g.getDate(parseInt(recID));
//        //if(validHash.equals(coded)&&stat.equals("Paid")){
//        if(stat.equals("Paid")){
//              
//           PaynowPoller paynowPoller = new PaynowPoller();
//           paynowPoller.pollPaynow(recID);
//           if ("unwritten".equals(paynowPoller.NAVwriteStatus(Integer.parseInt(recID)))){
//
//
//
//               String queryGL = "INSERT INTO [NUST2017].[dbo].[NUST_USD$BankTransactionLines]\n"+
//               "            ([Reference No_]\n" +
//               "           ,[Payment Date]\n" +
//               "           ,[Registration No_]\n" +
//               "           ,[Amount]\n" +
//               "           ,[Bank Code]\n" +
//               "           ,[Error Description]\n" +
//               "           ,[Transaction Posted]\n" +
//               "           ,[Post Transaction]\n" +
//               "           ,[Solution Description]\n" +
//               "           ,[Account]\n" +
//               "           ,[Department]\n" +
//               "           ,[Loan Code])\n" +
//               "     VALUES\n" +
//               "           ("+paynownumber+"\n" +
//               "           ,'"+strDate+"'\n" +
//               "           ,'"+ref+"'\n" +
//               "           ,'"+amnt+"'\n" +
//               "           ,'8010'\n" +
//               "           ,''\n" +
//               "           ,'0'\n" +
//               "           ,'1'\n" +
//               "           ,''\n" +
//               "           ,''\n" +
//               "           ,''\n" +
//               "           ,'')\n";    
//               writeToNAV(queryGL,Integer.parseInt(recID));
//
//System.out.println("Dollol");
//           } 
//        }        
       
    }

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
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
    
 public void writeToNAV (String query,int recID){
        DatabaseNav db1 = new DatabaseNav();
        db1.connect_db();
        if (db1.runQuery(query)){
        PaynowPoller paynowPoller = new PaynowPoller();
        //HT Changes 25/03/2018
        Date now = new Date();
        String dateTime = DateFormat.getInstance().format(now);
        
        
        String statusUpdateQuery = "UPDATE transactions SET NAV_Status = 'written', Status = 'Paid', date_posted_tonav = '" + dateTime 
                     + "' WHERE id =" + recID ; 
        //below is an entry made to trasactions table
        paynowPoller.writeToDatabase(statusUpdateQuery);
        } else {
            //we have failed to write to NAV
            //send an email.
            //the date and time
            //record ID
        }
        //return "navreference";
    }
}
