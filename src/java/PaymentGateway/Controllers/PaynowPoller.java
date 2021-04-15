/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;

import PaymentGateway.Model.AdmissionsMail;
import PaymentGateway.Model.PayNowInitiate1;
import PaymentGateway.Model.SHA512;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class PaynowPoller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String [] amountArray;
    String [] referenceArray;
    String [] paynowreferenceArray;
    String [] statusArray;
    String [] pollurlArray;
    String [] hashArray;
    
    private final String USER_AGENT = "Mozilla/5.0";
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            pollPaynow(Integer.parseInt(request.getParameter("id")));
         /*   response.setContentType("image/png");
            String pathToWeb=getServletContext().getRealPath(File.separator);
            File f = new File(pathToWeb + "nust-online.png"); 
            BufferedImage bi = ImageIO.read(f); 
            OutputStream out2 = response.getOutputStream(); 
            ImageIO.write(bi, "png", out2); out2.close();*/
            
            String googleAnalytics = "<!-- Global site tag (gtag.js) - Google Analytics -->";
            googleAnalytics = googleAnalytics + "<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-115633001-2\"></script>";
            googleAnalytics = googleAnalytics + "<script>";            
            googleAnalytics = googleAnalytics + "window.dataLayer = window.dataLayer || [];";
            googleAnalytics = googleAnalytics + "function gtag(){dataLayer.push(arguments);}";
            googleAnalytics = googleAnalytics + "gtag('js', new Date());";
            googleAnalytics = googleAnalytics + "gtag('config', 'UA-115633001-2');";
            googleAnalytics = googleAnalytics + "</script>";
            
            String logoSource="http://www.nust.ac.zw/images/headers/Mobile-pic.jpg";
            String styleColor="color:#003366;";
            String alt="nust_logo";
            String bodyStyle="width: 720px; padding: 10px; border: 2px solid #ddd;";
            String margin="width:800px; margin:20px auto 20px auto;";
            String h="120";
            String w="250";
            String buttonStyle="background:#00CED1; width:75%; border:0; padding:15px; color:#ffffff; font-size:14px;";
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("#trial{"+bodyStyle+ "}");
            out.println("#wara {"+margin+ "}");
            out.println("#but1 {"+buttonStyle+ "}");
            out.println("</style>");
            out.println("<title>Servlet PaynowPoller</title>"); 
            out.println(googleAnalytics); // there is potential of this causing slowness.
            out.println("</head>");
            out.println("<body>");
            out.println("<div id="+"wara"+">");
            out.println("<div id="+"trial"+">");
            out.println("<div><img src="+logoSource+" alt="+alt+" height="+h+" width="+w+"></div>");
            out.println("<h1 style="+styleColor+"> Thank You: " + referenceArray[1] + "</h1>");
            out.println("");
            out.println("<ul>");
            out.println("<li><p><b>Your payment reference number:</b>");
            out.println(paynowreferenceArray[1]);
            out.println("</p></li>");
            out.println("<li><p><b>Your payment status:</b>");
            out.println(statusArray[1]);
            out.println("</p></li>");
            out.println("<li><p><b>Amount under consideration</b>");
            out.println(amountArray[1]);
            out.println("<br/>");
            /*
            out.println("</p></li>");
            out.println("<li><p><b>Last  Name:</b>");
            out.println("<%= request.getParameter("status")%>");
            out.println("</p></li>");
            out.println("<li><p><b>First Name Xxx:</b>");
            out.println("<%= request.getParameter("pollurl")%>");
            out.println("</p></li>");
            out.println("<li><p><b>Pay now Hash :</b>");
            out.println("<%= request.getParameter("hash")%>");
            out.println("</p></li>");*/
           
            out.println("</ul>");
           
            out.println("<a href="+"http://www.nust.ac.zw"+"><button id="+"but1"+" >NUST HOME</button></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
            //Mopup();
            
        } catch (Exception ex) {
            Logger.getLogger(PaynowPoller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
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

      
    public void pollPaynow(int recID) throws Exception {

        try{
            /**
             * set up http:// post connection
             */
            String fullUrl = getPollurl(recID);
            fullUrl = fullUrl.trim();
            String url = fullUrl.substring(0,fullUrl.indexOf("?"));
            String urlParameters = fullUrl.substring(fullUrl.indexOf("?")+1);
            //String [] url2 = fullUrl.split("?");
            //url = url.trim();
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();            
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            
             
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            /**
             * the posting to paynow is done.
             * Below we get the reponse from paynow
             */

            int responseCode = con.getResponseCode();
            String responseValidator = con.getResponseMessage();
            StringBuilder content = new StringBuilder();

            // code for validating the response form paynow
            if (responseValidator.equals("OK") && responseCode==200){
             CloseableHttpClient httpclient = HttpClients.createDefault();
            }
            else {
            System.out.println("OOPS THERE IS AN ERROR :: OUR RESPONSE CODE FOR VALIDATION FROM PAYNOW: " + responseValidator+"... STATUS..:"+responseCode);
            }


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            //StringBuffer response = new StringBuffer();

                
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
             in.close(); 
            
            String pollResponse = content.toString();//response.toString();
            
            String [] pollResponseArray = pollResponse.split("&");
            for (int i = 0; i < (pollResponseArray.length);i++ ){
                if (pollResponseArray[i].toLowerCase().contains("amount")){
                    amountArray = pollResponseArray[i].split("=");
                };
                if (0 == pollResponseArray[i].toLowerCase().indexOf("reference")){
                    referenceArray = pollResponseArray[i].split("=");
                };
                if (pollResponseArray[i].toLowerCase().contains("paynowreference")){
                    paynowreferenceArray = pollResponseArray[i].split("=");
                };
                if (pollResponseArray[i].toLowerCase().contains("status")){
                    statusArray = pollResponseArray[i].split("=");
                };
                if (pollResponseArray[i].toLowerCase().contains("pollurl")){
                    pollurlArray = pollResponseArray[i].split("=");
                };
                if (pollResponseArray[i].toLowerCase().contains("hash")){
                    hashArray = pollResponseArray[i].split("=");
                };
            }
            //URLDecoder.decode(param1AfterEncoding, "UTF-8")
            String Key = "7b57815a-b2e7-47ae-a57a-cb3044d5850d";//Integration key sent by email once u create a button
           // String Key = "1747d3b9-27ad-4ae3-ba1c-13557544b62f";//integration key for test environment
            
            SHA512 sha = new SHA512();
            String password = referenceArray[1] + paynowreferenceArray[1] + amountArray[1] + statusArray[1]+ URLDecoder.decode(pollurlArray[1],"UTF-8")+ Key;
            if (sha.passHash(password).equals(hashArray[1])){
                if ("Paid".toLowerCase().equals(statusArray[1].toLowerCase())){
                    PaynowPoller paynowPoller = new PaynowPoller();
                    if ("unwritten".equals(paynowPoller.NAVwriteStatus(recID))){               
                       //write to NAV
                       DailyJob g = new DailyJob();
                      String strDate = g.getDate(recID);


                                    String queryGL = "INSERT INTO [NUST2017].[dbo].[NUST_USD$BankTransactionLines]\n"+
                       "            ([Reference No_]\n" +
                       "           ,[Payment Date]\n" +
                       "           ,[Registration No_]\n" +
                       "           ,[Amount]\n" +
                       "           ,[Bank Code]\n" +
                       "           ,[Error Description]\n" +
                       "           ,[Transaction Posted]\n" +
                       "           ,[Post Transaction]\n" +
                       "           ,[Solution Description]\n" +
                       "           ,[Account]\n" +
                       "           ,[Department]\n" +
                       "           ,[Loan Code]\n" +
                       "           ,[Currency Code])\n" +                        
                       "     VALUES\n" +
                       "           ("+paynowreferenceArray[1]+"\n" +
                       "           ,'"+strDate+"'\n" +
                       "           ,'"+referenceArray[1]+"'\n" +
                       "           ,'"+amountArray[1]+"'\n" +
                       "           ,'8010'\n" +
                       "           ,''\n" +
                       "           ,'0'\n" +
                       "           ,'1'\n" +
                       "           ,''\n" +
                       "           ,''\n" +
                       "           ,''\n" +
                       "           ,''\n"+
                       "           ,'')\n"; 
 
                       Listener listener = new Listener();
                       //the point where we are to comment out going to nav till 3rd of April 2018
                       // or we only depoly this solution after the 3rd of April 2018
                       
                       listener.writeToNAV(queryGL,recID);
                       System.out.println("Delay due to upgrade");
                       
                       //send email here
                       AdmissionsMail ad = new AdmissionsMail();
                       DailyJob dj = new DailyJob();
                       String email2 = dj.retrieveEmail(paynowreferenceArray[1]);
                      // ad.sendreceipt(email2, amountArray[1], paynowreferenceArray[1], referenceArray[1]);
                       //(String email, Double amount, String mobilenumber, String stud_id)
                       //send email
                    }
                    
                    //
                } else{
                //handle the other status
              //  if ("Cancelled".toLowerCase().equals(statusArray[1].toLowerCase()) ||"Created".toLowerCase().equals(statusArray[1].toLowerCase())||"Sent".toLowerCase().equals(statusArray[1].toLowerCase())){
                    //change the status to reflect the actual status in paynow1    
                    //String updateTransactionStatus = "UPDATE current SET status = 'Cancelled'"
                    //     + "WHERE id =" + recID + ";";
                    String updateTransactionStatus = "UPDATE transactions SET status = '" + statusArray[1] + "'"
                         + "WHERE id =" + recID + ";";
                    writeToDatabase(updateTransactionStatus);
                    
                }
                
            }
            
   
            /**
             * Decoding the response from paynow. reference
             */    
            } catch (Exception ex) {
                    //Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
   
    public Integer writeToDatabase (String query){
                try {
                    /* This is where we write to the database
                    */

                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                }
                    String url1 = "jdbc:mysql://127.0.0.1:3306/paynow1";
                String uName = "root";
               //String uPass = "";
                int recordID = 0;
		String uPass = "dread_woman";
                
                Connection conn;
                try {
                    conn = DriverManager.getConnection( url1 , uName, uPass);
                    PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    preparedStmt.executeUpdate();
                    ResultSet rs=preparedStmt.getGeneratedKeys();
                    if(rs.next()){
                        recordID = rs.getInt(1);
                    }
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                return recordID;
                
      
                
    
    }

    public String getPollurl (int id){
                try {
                    /* This is where we write to the database
                    */

                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                String url1 = "jdbc:mysql://127.0.0.1:3306/paynow1";
                String uName = "root";
               //String uPass = "";
                String strpollurl = "";
		String uPass = "dread_woman";
                
                Connection conn;
                try {
                    String query = "SELECT * FROM transactions WHERE id = " + id;
                    conn = DriverManager.getConnection( url1 , uName, uPass);
                    PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = preparedStmt.executeQuery();
                    //ResultSet rs=preparedStmt.getGeneratedKeys();
                    if(rs.next()){
                        strpollurl = rs.getString("poll_url");
                    }
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                }

                return strpollurl;   
    }    
    
    public String getStatus(){
        return statusArray[1];
    }
    
    public String NAVwriteStatus (int id){
        try {
            /* This is where we write to the database
            */

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
        }



        String url1 = "jdbc:mysql://127.0.0.1:3306/paynow1";
        String uName = "root";
       // String uPass = "";
        String strpollurl = "";
     String uPass = "dread_woman";
       // String uPass = "";

        Connection conn;
        try {
            String query = "SELECT * FROM transactions WHERE id = " + id;
            conn = DriverManager.getConnection( url1 , uName, uPass);
            PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStmt.executeQuery();
            //ResultSet rs=preparedStmt.getGeneratedKeys();
            if(rs.next()){
                strpollurl = rs.getString("NAV_status");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return strpollurl;   
    }     
   
    public void Mopup(){



            String url1 = "jdbc:mysql://127.0.0.1:3306/paynow1";
            String uName = "root";
            //String uPass = "";
            String strpollurl = "";
            String uPass = "dread_woman";

            Connection conn;
            try {
                String query = "SELECT id FROM transactions WHERE NAV_status ='unwritten' AND (status = 'Ok' OR status ='Paid')";
                conn = DriverManager.getConnection( url1 , uName, uPass);
                PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = preparedStmt.executeQuery();
                //ResultSet rs=preparedStmt.getGeneratedKeys();
                while (rs.next()!= false){
                    int recID = rs.getInt("id");
                    try {
                        PaynowPoller payPoll = new PaynowPoller();
                        payPoll.pollPaynow(recID);
                    } catch (Exception ex) {
                        Logger.getLogger(PaynowPoller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
            }            


            } 

}
