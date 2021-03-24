<%-- 
    Document   : paynowpoller
    Created on : Mar 18, 2018, 12:37:21 PM
    Author     : Administrator
--%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>

<% 


 
%>				
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

