<%-- 
    Document   : listener
    Created on : Mar 15, 2018, 8:31:09 AM
    Author     : Owen
--%>


<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="StudentApplicationReg.Model.DatabaseNav"%>
<%@page import="StudentApplicationReg.Model.SHA512" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Using GET and POST Method to Read Form Data</title>
   </head>
   
   <body>
      <center>
      <h1>Using GET Method to Read Form Data</h1>
      
      <ul>
         <li><p><b>First Name:</b>
            <%= request.getParameter("reference")%>
         </p></li>
         <li><p><b>Last  Name:</b>
            <%= request.getParameter("paynowreference")%>
         </p></li>
		 <li><p><b>First Name:</b>
            <%= request.getParameter("amount")%>
         </p></li>
         <li><p><b>Last  Name:</b>
            <%= request.getParameter("status")%>
         </p></li>
		 <li><p><b>First Name Xxx:</b>
            <%= request.getParameter("pollurl")%>
         </p></li>
         <li><p><b>Pay now Hash :</b>
            <%= request.getParameter("hash")%>
         </p></li>
      </ul>
         
          <%
             //String ref = request.getParameter("reference");
             //String paynownumber = request.getParameter("paynowreference");
             //String amnt = request.getParameter("amount");
             //String stat = request.getParameter("status");
             //String poll = request.getParameter("pollurl");
             //String coded = request.getParameter("hash");
             //String browseUrl =" ";
             String browseUrlValue =" ";
             String pollUrlValue = request.getParameter("pollurl");
             String resulturl = "";
             String integrationKey ="281c5dce-390d-4820-9257-2b05b61128b9";
             
             String resultUrlX ="";//http://localhost/sellingmilk.aspx?action=notify&order_id=2";
             String returnUrlValueX ="";//http://localhost/sellingmilk.aspx?action=return&order_id=2";
             String pollUrlValueX = request.getParameter("pollurl");
             String idX ="4931";
             String merchant_keyX ="281c5dce-390d-4820-9257-2b05b61128b9";
             String referenceX = request.getParameter("reference");
             String authemailX ="kitso.noko@hotmail.com";
             String statusX = request.getParameter("status");
             String amountX = request.getParameter("amount");
             String additionalinfoX = "";
             String paynowReferenceX = request.getParameter("paynowreference");
             
             
             //System.out.println("this is staus " + stat);
             //System.out.println("this is the amount" + amnt);
             //System.out.println("this is the applicant number " + ref);
             //System.out.println("this is the paynow reference " + paynownumber);
             //System.out.println("this is the poll url" + poll);
             //System.out.println("this is the hash " + coded);
              
          
            SHA512 cash = new SHA512();
           
            //>>>>Test code
            String password1 = pollUrlValueX + resultUrlX + returnUrlValueX + paynowReferenceX + referenceX + amountX + idX + additionalinfoX + authemailX + statusX + merchant_keyX;
            //String password1 =  resultUrlX + returnUrlValueX + paynowReferenceX + referenceX + amountX + idX + additionalinfoX + authemailX + statusX + merchant_keyX;
            
//ref+paynownumber+amnt+stat+poll+integrationKey;
            //<<<<Test code end
            
             //String password1 = ref+paynownumber+amnt+stat+poll+integrationKey;
             
             String validHash = cash.passHash(password1);
             //String validHash = cash.passHash("Hamadziripi Tsokodayi");
             //String validHash = cash.(password1);
              //System.out.println("values for hash creation" +password1); 
                //System.out.println("This is the hash we created with all the values ffff" +validHash);     
 
        %>
         
   
   
              <li><p><b>Password :</b>
            <%= password1%>
         </p></li>
            <li><p><b>Valid Hash :</b>
            <%= validHash%>
         </p></li>
      </ul>
   
   </body>
</html>