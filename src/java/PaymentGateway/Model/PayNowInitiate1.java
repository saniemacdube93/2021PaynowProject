/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Model;

/**
 *
 * @author Owen
 */


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import static org.apache.http.client.methods.RequestBuilder.post;
import static org.apache.http.client.methods.RequestBuilder.post;
import static org.apache.http.client.methods.RequestBuilder.post;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;
//import org.json.
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import org.springframework.util.StringUtils;
//import students.portal.model.SHA512;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import StudentApplicationReg.Controllers.PersonalDetails;
import javax.servlet.http.HttpSession;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import StudentApplicationReg.Controllers.PersonalDetails;
import static java.lang.System.out;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayNowInitiate1 {
  /* HttpSession session = request.getSession();
            String applicantId = (String)session.getAttribute("appId"); 
            
            System.out.println("this is the applicant id in PayNow controller\n"+applicantId);
            session.setAttribute("appId", applicantId);**/
        Database db = new Database();
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		//PayNowInitiate http = new PayNowInitiate();

		System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		//khttp.();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "https://www.paynow.co.zw/interface/initiatetransaction";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}

	// HTTP POST request
	
        
    public String sendPost1(String appID2,Double Amount,String MobileNumber, String Email) throws Exception {
        
        //String Id = "3303";// Live ID FOR APPLICATION FEES
        // String Id = "4931";// Test ID
        String Id = "3270";// LIVE ID FOR NUST FEES
        
        String Status = "Message";
        
        //String Key = "6f7b96b8-60a5-4e6c-827e-e2c87e3c552a";// Live environment Integration key FOR APPLICATION FEES sent by email once u create a button
        //String Key = "1747d3b9-27ad-4ae3-ba1c-13557544b62f"; // Test environment
         String Key = "7b57815a-b2e7-47ae-a57a-cb3044d5850d"; // LIVE ID FOR NUST FEES environment
        String returnUrl ="http://apply.nust.ac.zw/PaynowPoller?id="; // Live environment
        //String returnUrl ="http://196.220.96.82:8080/WebApplication2/PaynowPoller?id="; // Test environment
        //http%3a%2f%2f196.220.96.82%3a8080%2fWebApplication2%2fPaynowPoller%3fid%3d109
        String postUrl = "http://apply.nust.ac.zw/Listener?id="; // Live environment
        //String postUrl ="http://196.220.96.82:8080/WebApplication2/Listener?id="; //Test environment
        //http%3a%2f%2f196.220.96.82%3a8080%2fWebApplication2%2fListener%3fid%3d109
        //String authemail ="kitso.noko@hotmail.com";
        String url = "https://www.paynow.co.zw/interface/initiatetransaction";
        
        try{
            
            String hashCode;
            /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();    

        
            System.out.println("applicantId" +appID2); 
            String url2 = "jdbc:sqlserver://196.220.119.9:1433;databaseName=NUST_2009";
            //String url2 = "jdbc:sqlserver://196.220.119.58:1433;databaseName=NUST_2009";
            String uName2 = "umgaga";
            //String uPass = "n4v1510n";
            String uPass2 = "Mdaka@nust.ac.zw";		
            //String url = "jdbc:mysql://127.0.0.1:3306/onlineapplication";
            //String uName2 = "sa";
            //String uPass2 = "Monday1@nust.ac.zw";**/
            
            //Date now = new Date();
            //String dateTime = DateFormat.getInstance().format(now);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate dateTime = LocalDate.now();
            System.out.println(dtf.format(dateTime)); //2016/11/16
            //String uPass = "";
           // Connection conn1 = DriverManager.getConnection( url2 , uName2, uPass2);
            System.out.println("Database connection established");
             
            //PersonalDetails g = new PersonalDetails();
            
    
            /**
             * proposed place to input into database and obtain the record ID
             */
            String order_query = "INSERT INTO transactions (converted, initial_amount, telephone, email, applicantId)"
                    + " VALUES ('" + dateTime + "','" + Amount + "','" +  MobileNumber + "','" + Email + "','" + appID2 +"');";
            int recordID = writeToDatabase(order_query);
            //If no recordId has been assigned the transaction doesnt go through an error page is exhibited and email sent
            if (recordID == 0){
                //send an email sent to us.
                AdmissionsMail ms = new AdmissionsMail();
                //ms.senderror("software@nust.ac.zw", Amount, MobileNumber, appID2);
                //sendreceipt(String email, String amount, String reference, String stud_id);
                
                return "https://apply.nust.ac.zw/internalError.jsp";//return error page. do not proceed.   
            }
            /**
             * set up http:// post connection
             */
            
            //recordID = 109;
            
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            System.out.println("IM NOW IN SEND POST ONE .... kkkk");
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            //Double Amount1 = 1.01;
            /*// This pertains to live deployment
            String urlParameters = "id=3303&reference="+appID2+"&amount="+Amount1+"&additionalinfo="+appID2+"&returnurl=http%3a%2f%2fapply.nust.ac.zw%2fapplicationSubmitted.jsp&authemail="+Email+"&resulturl=http%3a%2f%2f196.220.96.95%3a8081"
                    + "&status=Message&"
                    + "hash="+hashCode+"";**/
            SHA512 sh = new SHA512();
            // code for the test environment
            //getPaymentInfo(Double Amount, String appID2, String Email, String MobileNumber, String returnUrl, String Id, String Key, String postUrl, String Status)
            
            // This pertains to live deployment
            
            //String urlParameters = "id=3303&reference="+appID2+"&amount="+Amount1+"&additionalinfo="+appID2+"&returnurl=http%3a%2f%2fapply.nust.ac.zw%2fapplicationSubmitted.jsp&authemail="+Email+"&resulturl=http%3a%2f%2f196.220.96.95%3a8081"
            //        + "&status=Message&"
            //        + "hash="+hashCode+"";

            //hashCode = sh.getPaymentInfo(Amount, appID2, Email, MobileNumber ,(returnUrl + recordID), Id, Key,(postUrl+recordID), Status); 
            
            hashCode = sh.getPaymentInfo(Amount, appID2, Email, MobileNumber ,(returnUrl+recordID), Id, Key, (postUrl+recordID), Status); 
            
            //String urlParameters = "id=" + Id + "&reference=" + appID2 + "&amount=" + Amount + "&additionalinfo=" + appID2 + "&returnurl=" + returnUrl  + recordID 
            //        + "&authemail=" + Email + "&resulturl=" + postUrl + recordID
            //        + "&status=Message&"
            //        + "hash="+ hashCode + "";

            String urlParameters = "id=3270&reference="+appID2+"&amount="+Amount+"&additionalinfo="+appID2+"&returnurl=http%3a%2f%2fapply.nust.ac.zw%2fPaynowPoller%3fid%3d"+recordID+"&authemail="+Email+"&resulturl=http%3a%2f%2fapply.nust.ac.zw%2fListener%3fid%3d"+recordID
                    + "&status=Message&"
                    + "hash="+hashCode+"";



            
            //urlParameters = URLEncoder.encode(urlParameters, "UTF-16");
            //urlParameters = URLEncoder.encode(urlParameters);
            
//            String urlParameters = "id=4931&reference="+appID2+"&amount="+Amount+"&additionalinfo="+appID2+"&returnurl=http%3a%2f%2f196.220.96.82%3a8080%2fWebApplication2%2fPaynowPoller?id%3d" + recordID + "&authemail="+Email+"&resulturl=http%3a%2f%2f196.220.96.82%3a8080%2fWebApplication2%2fListener?id%3d" + recordID
//                      + "&status=Message&"
//                      + "hash="+ hashCode + "";
            //String unencodedurl = URLDecoder.decode(urlParameters, "UTF-16");
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            //con.setRequestProperty("charset","utf-8");
            wr.writeBytes(urlParameters.trim());
            wr.flush();
            wr.close();
            /**
             * the posting to paynow is done.
             * Below we get the reponse from paynow
             */

            int responseCode = con.getResponseCode();
            String responseValidator = con.getResponseMessage();
            String responseValidator1 = con.getRequestMethod();
            System.out.println(con.getResponseMessage());
            System.out.println("\nSending 'POST' request to URL jjjjj : " +responseValidator1 );
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Our Response from paynow is : " + responseValidator);
            StringBuilder content = new StringBuilder();

            // code for validating the response form paynow
            if (responseValidator.equals("OK") && responseCode==200){
             System.out.println("OUR RESPONSE CODE FOR VALIDATION FROM PAYNOW: " + responseValidator+"... STATUS..:"+responseCode);
             CloseableHttpClient httpclient = HttpClients.createDefault();
            //HttpGet httpGet = new HttpGet("http://targethost/homepage");
            //CloseableHttpResponse response1 = httpclient.execute(httpGet);
             
            }
            else {
            System.out.println("OOPS THERE IS AN ERROR :: OUR RESPONSE CODE FOR VALIDATION FROM PAYNOW: " + responseValidator+"... STATUS..:"+responseCode);
            }


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

                
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
                
            /**
             * Decoding the response from paynow.
             */    
                
            Object obj1;
            obj1 = JSONValue.parse(content.toString());
            JSONArray finalResult=(JSONArray)obj1;
            //data = response.split("&");
 
            System.out.println("THIS IS THE RESPONSE FROM PAYNOW"+content);
            String  converted = content.toString();
            String zie1 =         URLDecoder.decode(converted);
            //zie1= zie1.split("&");
            System.out.println("PAYNOW RESPONSE  \n "+converted+'\n');
            String [] zzzz = converted.split("&");


            System.out.println("THE PARAMETERS ARE FINAL ZIBUSISO"+Arrays.toString(zzzz));
            String dddd = Arrays.toString(zzzz);
            //zzzz.toString();

            System.out.println("DREADMAN EDWIN"+zzzz);

            System.out.println("THE PARAMETERS ARE FINAL ZIBUSISO EDWIN"+dddd);
               
            String [] paynow = dddd.split("=");
            System.out.println("WHY NOT THESE PARAMETERS ARE FINAL ZIBUSISO EDWIN"+Arrays.toString(paynow));
            HashMap<String, String> parameters = new HashMap<String, String>();

            String query = converted;
            List<NameValuePair> params = URLEncodedUtils.parse(query, Charset.defaultCharset());
            for (NameValuePair nameValuePair : params) {
                parameters.put(nameValuePair.getName(), nameValuePair.getValue());
            }
               
            System.out.println("THE PARAMETERS ARE"+params);
       
            String arraylistToString = StringUtils.collectionToCommaDelimitedString(params);
        
            System.out.println("THE PARAMETERS ARE FINAL ::"+arraylistToString);
          
            String [] paynow3 = arraylistToString.split("=");
            String paynow4 = Arrays.toString(paynow3);
         
            String [] paynow5 = paynow4.split(",");
     // String [] stockArr = params.toArray((T[]) new NameValuePair[0]);
            System.out.println("THE PARAMETERS ARE FINAL 55 ::"+Arrays.toString(paynow5));
      
            String status = paynow5[0];
            String statusValue = paynow5[1];
            String browseUrl = paynow5[2];
            String browseUrlValue = paynow5[3];
            String pollUrlValue = paynow5[5];
            String pollUrl = paynow5[4];
            
            String intergrationKey = paynow5[6];
            String hash = paynow5[7];
            String hashValue = paynow5[8];
      
            System.out.println("THE STATUS IS  ::"+status);
            System.out.println("THE STATUS VALUE IS  ::"+statusValue);
            System.out.println("THE BROWSE URL  IS  ::"+browseUrl);
            System.out.println("THE BROWSEALUE URL  IS  ::"+browseUrlValue);
            System.out.println("THE POLL URL    ::"+pollUrl);
            System.out.println("THE POLL URL VALUE IS   ::"+pollUrlValue);
            System.out.println("THE INT KEY  IS  ::"+intergrationKey);
            System.out.println("THE HASH IS   ::"+hash);
            System.out.println("THE HASH VALUE IS   ::"+hashValue);
            System.out.println("THE  STUDENT ID IS HASH VALUE IS   ::"+appID2);
            System.out.println("THE INITIAL AMOUNT ON THE    ::"+Amount);
            System.out.println("THE  STUDENT Telephone IS HASH VALUE IS   ::"+MobileNumber);
            System.out.println("THE Email is     ::"+Email);


            System.out.println("THE HASH VALUE    ::"+hashValue);
            System.out.println("THE HASH VALUE IS   ::\n"+hashValue);
               
             String [] browseUrlSplit = browseUrlValue.split("/");
               
            System.out.println("SPLIT BROWSE URL ::.."+Arrays.toString(browseUrlSplit));
            String payNowRef = browseUrlSplit[5];
            System.out.println("REFERENCE VALUE CAN BE FOUND ::.."+payNowRef);
               
               
            
            String hashValue1 = hashValue.replaceAll("]", "");
            String hashValue2 = hashValue1.replaceAll(" ", "");
            SHA512 mimie = new SHA512();
            String validHash = (mimie.getValidHash(statusValue,pollUrl, browseUrl, browseUrlValue, pollUrlValue, intergrationKey, hashValue));
            String validHashZ = validHash.replaceAll(" ", "");
            System.out.println(validHashZ);
            System.out.println(hashValue2);
            
            if ( validHashZ.equals(hashValue2)){
                
                //System.out.println(" DATE AND TIME IS ::.. " + DateFormat.getInstance().format(now));
                /**
                 * This is where we write to the database
                 */
                /**
                 * New code for writing to the database with and update query
                 */
                String updateQuery = "UPDATE transactions SET browser_url = '" + browseUrlValue.trim() + "', poll_url = '" + pollUrlValue.trim() + "=" + intergrationKey.trim() + "', paynow_reference = '" + payNowRef.trim() + "', status = '" + statusValue.trim() + "'"
                     + "WHERE id =" + recordID + "; ";
                writeToDatabase(updateQuery);
                //********//
                //HT edited 24/02/2018
                //we should not proceed if we fail to write to the database at this stage
                // done step by step to really follow the sql statements. remove later!!
                //tried to combine the sql statements into one but failed for now.
                String checkUpdateQuery = "SELECT * FROM transactions WHERE id =" + recordID + ";";
                String paynowRef = writeToDatabase2(checkUpdateQuery);
                //If paynowRef has no value transaction stops
                if (paynowRef.equalsIgnoreCase("")){
                AdmissionsMail ms = new AdmissionsMail();
              //  ms.senderror("software@nust.ac.zw", Amount, MobileNumber, appID2);
                return "https://apply.nust.ac.zw/internalError.jsp"; //return error page. do not proceed.
                }                       

                System.out.println("DB CONNECTION SHED ON PAYNOW INITIATE ");
                //return browseUrlValue;
             
                System.out.println("THIS IS JUST THE BEGINNING .......???"+validHash);
                System.out.println("THIS CODE FOR STORING IN TO DATABASE JUST THE BEGINNING .......???");
                return browseUrlValue;
                }
                System.out.println("THIS IS JUST THE BEGINNING  zie.......???");
       
            //System.out.println("THE PARAMETERS ARE"+Arrays.toString(stockArr));
            //String [] dd = params.spliterator("&");
            String[] details;
            String s20="";
            //boolean sInArray = Arrays.stream(details).anyMatch("s"::equals); 
            details = zie1.split("&");
            System.out.println("THE NNNNN NNNNNN NNNNN "+details);
            for (int x=0;x<details.length;x++){
                String s="s";
                String[] d = details[x].split("=");
                System.out.println(d );
                //if(d.length == 2)
                for (int i=0; i< d.length ; i++) {
                    System.out.println("String s :"+x+i+" = "+d[i]);         
                    System.out.println("AND THE VALUE IS : "+status);
                }  
            }
       
            while ((inputLine = in.readLine()) != null) {
               if (inputLine.matches("OK"))
               {
               System.out.println("contains ok ssss"+response);
               }
               String response_text = null;

            HttpEntity entity = null;
            //entity = response//.getEntity();

            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = in.readLine()) != null) {
            sb.append(output);
            System.out.println("hambe shwa"+output);
            //return sb.toString();}
            }
                   
            System.out.println("contains ok bbbbb");
            response.append(inputLine +"\n");

            System.out.println(inputLine);
            System.out.println("contains ok" + response);

            //String zie =         URLDecoder.decode(inputLine);
            String zie =         URLDecoder.decode(converted);
               
            System.out.println("Hope it decoded "+zie);
            String valid = "OK";
            System.out.println("Hope it decoded "+zie);
            //String valid = "OK";
            if (responseValidator.equals(valid)) {

               System.out.println("\nSTATUS IS OK WE ARE NOW WRITING TO DATABASE: " + responseValidator);
               
               JSONObject myObject = new JSONObject(response);
               
               
               System.out.println(myObject);
               
               System.out.println("\nSTATUS IS OK WE ARE NOW WRITING TO DATABASE: " + responseValidator);
               }
                        
                   
            }
            in.close();

		//print result
            System.out.println(response.toString());
             
                //System.out.println("blalalalalalalal "+o);
            List<String> response1 = new ArrayList<String>();
  
            Map<String, List<String>> map = con.getHeaderFields();
            System.out.println("Printing Response Header...\n");
            //String responseBody = httpclient.execute(httpget, responseHandler);
        
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		System.out.println("Key : " + entry.getKey()
                           + " ,Value : " + entry.getValue());
            }

            System.out.println("\nGet Response Header By Key ...\n");
            String server = con.getHeaderField("Server");

            if (server == null) {
                    System.out.println("Key 'Server' is not found!");
            } else {
                    System.out.println("Server - " + server);
            }

            System.out.println("\n Done");
                
                /****/
            return null;
            }
            finally {
            out.close();
            }
            }    
   
    public Integer writeToDatabase (String query){
      try{  
      Class.forName("com.mysql.jdbc.Driver").newInstance(); 
      }catch(Exception w){
          w.printStackTrace();
      }
      String url1 = "jdbc:mysql://127.0.0.1:3306/paynow1";
      String uName = "root";
     String uPass = "dread_woman";
      int record = 0 ;
      //String uPass ="";// "dread_woman";
                
       Connection conn; 
                
              
                try {
                    
                    
                    conn = DriverManager.getConnection( url1 , uName, uPass);
                    PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    preparedStmt.executeUpdate();
                    ResultSet rs=preparedStmt.getGeneratedKeys();
                    if(rs.next()){
                     record = rs.getInt(1);
                     
                    }
                    db.close_db();
                } catch (SQLException ex) {
                    Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                }
                 int recordID = record; 
                
                return recordID;
                
      
                
    
    }

    public String writeToDatabase2 (String query){
         try{  
         Class.forName("com.mysql.jdbc.Driver").newInstance(); 
         }catch(Exception w){
             w.printStackTrace();
         }
         String url1 = "jdbc:mysql://127.0.0.1:3306/paynow1";
         String uName = "root";
       //  String uPass = "";
         String paynowRef ="" ;//= new ResultSet();// = 0;
         
         String uPass ="dread_woman";// "dread_woman";

          Connection conn; 


                   try {

                       conn = DriverManager.getConnection( url1 , uName, uPass);
                       PreparedStatement preparedStmt = conn.prepareStatement(query);//,Statement.RETURN_GENERATED_KEYS);
                       //preparedStmt.executeUpdate();
                       ResultSet rs=preparedStmt.executeQuery();
                       //return rs1 = rs;
                       if(rs.next()){
                           paynowRef = rs.getString("paynow_reference");
                       }
                       conn.close();
                       //db.close_db();
                   } catch (SQLException ex) {
                       Logger.getLogger(PayNowInitiate1.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return paynowRef;
       }
}