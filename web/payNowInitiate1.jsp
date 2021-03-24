<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="en" class="no-js"> <![endif]-->
<!--[if !(IE)]><!-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
	<title>NUST| PAY ONLINE</title>
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
</head>

<body>
	<div class="wrapper full-page-wrapper page-auth page-register text-center">
		<div class="inner-page">
			<div class="logo">
				<img src="assets/images/nust-online.png" alt="" />
			</div>
			<div class="main-header">
					<h2>PAYNOW INTERFACE</h2>
					<em>Making life much easier</em>
                                        
                                        <p class="form-control-static" style="text-align: center"><img src="assets/images/paynow-logo.png" alt="Paynow Badge" /></p>
                                      
				</div>
			
			<div class="register-box center-block">
				 
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
							<p>
  <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Link with href
  </a>
  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
    Button with data-target
  </button>
</p>
<div class="collapse" id="collapseExample">
  <div class="card card-body">
    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
  </div>
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
	</div>
	</br>
	</br>
	</br>
	<!--<div class="footer">&copy; 2014-2015 The Develovers</div>
	<!-- Javascript -->
	<script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/plugins/modernizr/modernizr.js"></script>
</body>

</html>
