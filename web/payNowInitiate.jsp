<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="en" class="no-js"> <![endif]-->
<!--[if !(IE)]><!-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
	<title>NUST | PayOnline </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="description" content="KingAdmin Dashboard">
	<meta name="author" content="The Develovers">
	<!-- CSS -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/main.css" rel="stylesheet" type="text/css">
	<!--[if lte IE 9]>
		<link href="assets/css/main-ie.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/main-ie-part2.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<!-- Fav and touch icons -->

	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/kingadmin-favicon144x144.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/kingadmin-favicon114x114.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/kingadmin-favicon72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="57x57" href="assets/ico/kingadmin-favicon57x57.png">
	<link rel="shortcut icon" href="assets/ico/favicon.png">
        
        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-115633001-2"></script>
        <script>
          window.dataLayer = window.dataLayer || [];
          function gtag(){dataLayer.push(arguments);}
          gtag('js', new Date());

          gtag('config', 'UA-115633001-2');
        </script>     
        
</head>

<body class="sidebar-fixed topnav-fixed">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- WRAPPER -->
        <!--<div class="wrapper full-page-wrapper page-auth page-login text-center">-->
	<div id="wrapper" class="wrapper">
		<!-- TOP BAR -->
		
		<!-- END TOP BAR -->
		<!-- MAIN CONTENT WRAPPER -->
		<div id="main-content-wrapper" class="content-wrapper ">
			
			<!-- end top general alert -->
			<div class="row">
				
				<div class="col-lg-8 ">
					<div class="top-content">
						<ul class="list-inline quick-access">
							
							
							
						</ul>
					</div>
				</div>
			</div>
			<!-- main -->
			<div class="content">
                            <div class="logo">
				<img src="assets/images/nust-online.png" alt="nustlogo" />
			</div>
				<div class="main-header">
					<h2>PAYNOW INTERFACE</h2>
					<em>Making life much easier</em>
                                      
				</div>
                            <!--<div class="wrapper full-page-wrapper page-auth page-login text-center">-->
				<div class="main-content" width="100%">
                                    <div class="row">
                                     <div class="col-md-3">
							<!-- ADVANCED VALIDATION -->
							
							<!-- END ADVANCED VALIDATION -->
						</div>
                                    
                                    <div class="col-md-6">
							<!-- ADVANCED VALIDATION -->
                                                        
                      
							<div class="widget">
                                                          	 <div class="demo-popover1">
                                                            <!-- <button type="button" class="btn btn-danger btn-block"><p><strong><h4>FEES BALANCE</h4></strong></p></button>-->
                                                       
                                                             <div class="form-group">
										
										
                                                                                    <p class="form-control-static" style="text-align: center"><img src="assets/images/paynow-logo.png" alt="Paynow Badge" /></p>
										
                                                                                
									</div>
                                                           
                                                        
                                                                 </div>
                                                        
							
					
                                                       
                                                         
								<!--<div class="widget-header">
									<h3><i class="fa fa-check-circle"></i>Please Enter Your Details</h3></div>-->
								<div class="widget-content">
                                                                     
                                
                                                                    
                                                                     <form class="form-horizontal form-ticket" data-toggle="validator" action="${pageContext.request.contextPath}/PayNow2" method="post">
                                                                         <c:forEach items="${StudentDetails}" var="student">
                                                                         <div style="padding-bottom: 20px;">
                                                                                <em><small>Please Enter Your Details. Field marked * is required</small></em>
                                                                         </div>  
                                                                                <div>
                                                                                    <input type="hidden" name="studNumber" value="<c:out value="${student.studentNumber}"/>"/>
                                                                                   <p style="text-align: center;"><strong> <c:out value="${student.studName}"/>  <c:out value="${student.studSurname}"/></strong></p></th></table>
										</div>
                                                                                <div>
										    <p style="text-align: center;"><strong> <c:out value="${student.studentNumber}"/></strong></p></th></table>
										</div>
                                                                                <div>
										    <p style="text-align: center;"><strong>    <c:out value="${student.studProg}"/></strong></p></th></table>
										</div>
                                                                            <fieldset>
                                                                           
                                                                       <div class="form-group">
										<!--<label for="telephone" class="col-sm-3 control-label">* Mobile Number</label>-->
                                                                                <div style="padding:10px;">
                                                                                    <input name="telephone" type="text" class="form-control" id="ticket-email" placeholder="Mobile Number" required="required" pattern="^\d{4}\d{3}\d{3}$">
                                                                                </div>
									
                                                                               
										<!--<label for="email" class="col-sm-3 control-label">* Preferred Email</label>-->
										 <div style="padding:10px;">
                                                                                    <input name="email" type="email" class="form-control" id="ticket-email"  placeholder="Email" required="required">
										<div class="help-block with-errors"></div>
                                                                                 </div>
									
                                                                                  
										<!--<label for="amount" class="col-sm-3 control-label">* Amount</label>-->
										 <div style="padding:10px;">
                                                                                    <input name="amount" type="number" class="form-control" id="ticket-email" placeholder="Amount" required="required" step="any">
                                                                                 </div>
									</div>
                                                                                
                                                                               
                                                                                
                                                                                <div class="form-group">
											
                                                                                       
                                                                                   <label class="col-sm-9">
												
												<span>
						
							<div class="panel-heading">
                                                            
                                                            
								<h1 class="panel-title">
								<input type="checkbox" name="checkbox3" required data-parsley-range="[1,2]" data-parsley-errors-container="#error-checkbox3">	<a data-toggle="collapse" data-parent="#accordion" href="#faqb1" class="collapsed">Check here to indicate you have read and agree to the terms and conditions.</a>
								</h1>
							</div>
							<div id="faqb1" class="panel-collapse collapse" style="text-align: center;">
								
									<p>National University Of Science And Technology (NUST) offers you the option of paying fees & other outstanding amounts
on your student account, by using the online payment facilities.
For making online payment, you will access a third party site. NUST does not in any way warrant the
accuracy or completeness of the information, materials, services or the reliability of any service, advice,
opinion, statement or other information displayed or distributed through such third party site. Students
may access this site solely for purposes of repayment of your fees and you understand and acknowledge
that availing of any services offered on the site or your reliance on any opinion, advice, statement,
memorandum, or information available on the site shall be at your sole risk and discretion.
Due to the way transactions are processed by the such third party bank sites, there may be delays in
updating your payment in our records. It remains the Student's responsibility to verify success of the
payment, with its the third party site.
                                                                        </p>
									
                                                                      
								
							</div>
						
						
						
					</span>
											</label>
										
										
										</div>
                                                                                </fieldset>
                                                                                <button type="submit" class="btn btn-primary">Submit</button>
                                                                                </c:forEach>
									</form>
								</div>
							</div>
							<!-- END ADVANCED VALIDATION -->
						</div>
                                     <div class="col-md-4">
							<!-- ADVANCED VALIDATION -->
							
							<!-- END ADVANCED VALIDATION -->
						</div>
                                    </div>
                                    
					<div class="text-center bottom-60px">
                                            
                                            
                                        </div>
					
					<div class="row">
						
						
					</div>
				</div>
			</div>
			<!-- /main -->
			<!-- FOOTER -->
			
			<!-- END FOOTER -->
		</div>
		<!-- END CONTENT WRAPPER -->
	</div>
	<!-- END WRAPPER -->
	
	<!-- Javascript -->
        
	<script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/plugins/modernizr/modernizr.js"></script>
	<script src="assets/js/plugins/bootstrap-tour/bootstrap-tour.custom.js"></script>
	<script src="assets/js/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/js/king-common.js"></script>
	<script src="demo-style-switcher/assets/js/deliswitch.js"></script>
	<script src="assets/js/plugins/bootstrap-multiselect/bootstrap-multiselect.js"></script>
	<script src="assets/js/plugins/parsley-validation/parsley.min.js"></script>
	<script src="assets/js/king-elements.js"></script>
        <script src="assets/js/validator.js"></script>
        
       

	<script src="assets/js/king-form-layouts.js"></script>
</body>

</html>

