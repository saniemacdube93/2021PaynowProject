/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;

import PaymentGateway.Model.DatabaseNav;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DailyJob {
    private String amountArray;
    private String referenceArray;
    private String paynowreferenceArray;
    private String statusArray;
    private String pollurlArray;
    private String hashArray; 
    private int id;
    private String email;
    private String strDate; 
    
    public String getStrdate(){
        return strDate;
    }
    public String getEmail(){
        return email;
    }
    
    public int getId(){
        return id;
    }
   
    
    public static void main(String[] args) { 
        int delay = 5000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                DailyJob dj = new DailyJob();
                dj.poller();
            }
        }, delay, delay);
    } 
    
       public String retrieveEmail(String paynowreference){
            String url = "jdbc:mysql://127.0.0.1:3306/paynow1";
            String uName = "root";
           String uPass = "dread_woman";
          // String uPass = "";
            String res = null;
            Connection conn;
            
                try {
                        
                    conn = DriverManager.getConnection( url , uName, uPass);
                    String query = "SELECT email FROM transactions WHERE paynow_reference ='"+paynowreference+"'";
                    PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = preparedStmt.executeQuery();
                    if(rs.next()){
                        
                        DailyJob e = new DailyJob();
                        
                       e.email = rs.getString("email");
                       res = e.email;
                         
                        }
                    conn.close();
                    return res;
               
                }catch (SQLException ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                } catch (Exception ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
                  
       }
        
        
        public void poller(){
            
            try {
                    /* This is where we write to the database
                    */

                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                String url = "jdbc:mysql://127.0.0.1:3306/paynow1";
                String uName = "root";
                String uPass = "dread_woman";
               //String uPass ="";
                
                Connection conn;
                try {
                        
                    conn = DriverManager.getConnection( url , uName, uPass);
                    String query = "SELECT id FROM transactions WHERE status ='Ok'";
                    //PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement preparedStmt = conn.prepareStatement(query);//,Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = preparedStmt.executeQuery();
                    List<DailyJob>Stat = new ArrayList<DailyJob>();
                   // Gugu.add(e)
                    //ResultSet rs=preparedStmt.getGeneratedKeys();
                    if(rs.next()){
                        
                        DailyJob e = new DailyJob();
                    /*    e.amountArray = rs.getString("final_amount");
                        e.referenceArray = rs.getString("applicantId");
                        e.paynowreferenceArray = rs.getString("paynow_reference");
                        e.pollurlArray = rs.getString("poll_url").trim();
                        e.hashArray = rs.getString("");
                        e.statusArray = rs.getString("");
                       // e.id = Integer.parseInt(rs.getString("id"));**/
                       //e.id = Integer.parseInt(rs.getString("id"));
                        //HT edit
                        int id2;
                        int i = 0;//temporary so that we do not run out of test data
                        while (rs.next()!= false){
                        id2 = rs.getInt(1);
                       // id2=10824;
                        i++;
                        PaynowPoller pp = new PaynowPoller();
                        if (i<500){ //temp so that we do not run out of test data.
                        pp.pollPaynow(id2);
                        }
                        }
                        
                      
                       
                        
                        //Stat.add(e);
                       
                        //for (int i = 0; i < Stat.size();i++ ){
                            //String urlParameters = "id='"+Stat.get(i).getId();
                        //    int id1 =id+Stat.get(i).getId();
                        //    System.out.println(id1); 
                           //pollurlArray[i] = "poll_url?id=+'"+id[i]+"'&";     
                        //PaynowPoller pp = new PaynowPoller();
                        //pp.pollPaynow( id1);
                        
                        
                       // strpollurl = rs.getString("poll_url");
                        //}
                    conn.close();
                } 
                  
                
               
            }   catch (SQLException ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
     public String getDate(int id){
           
         
         try {
                    /* This is where we write to the database
                    */

                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                String url = "jdbc:mysql://127.0.0.1:3306/paynow1";
                String uName = "root";
           	String uPass = "dread_woman";
                //String uPass ="";
                
                Connection conn;
                String res = null;
           try {
            
               
                    conn = DriverManager.getConnection( url , uName, uPass);
                     String moddate = null;

                    //conn = DriverManager.getConnection( url , uName, uPass);
                    String query = "SELECT converted FROM transactions where id ='"+id+"'";                   
                    PreparedStatement preparedStmt = conn.prepareStatement(query);//,Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = preparedStmt.executeQuery();
                    if(rs.next()){
                        
                        DailyJob d = new DailyJob();
                        d.strDate = rs.getString("converted");
                        moddate = d.strDate;
                        System.out.println("Date is " + d.strDate);
                       
                    }
                    String moddate1 = moddate.replace("-","/");
                    System.out.println(moddate1);
                    Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(moddate1);
                    System.out.println(date1);
                    //date = dateFormat.parse(dateStr);
                    DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    res = sdf.format(date1);
                    System.out.println(res);
                    conn.close(); 
                    return res ;
             
                }catch (SQLException ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                } catch (Exception ex) {
                    Logger.getLogger(DailyJob.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
   
     }
}
