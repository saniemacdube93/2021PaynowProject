<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie ie9" lang="en" class="no-js"> <![endif]-->
<!--[if !(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
	<title>NUST | PayOnline  </title>
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

<body>
 <div class="wrapper full-page-wrapper page-auth page-login text-center">
            		<div class="inner-page">
                            <div class="logo">
				<img src="assets/images/nust-online.png" alt="" />
			</div>
			<!--<div class="logo">
                            <ahref "login.jsp"><img src="assets/images/nust_logo.png" alt="">
			</div>-->
			<!--<button type="button" class="btn btn-auth-facebook"><span>Login via Facebook</span></button>
			<div class="separator"><span>OR</span></div>-->
			<div class="separator"><span>PAY ONLINE</span></div>
                        <div class="login-box center-block ">
				<form id="formT" data-parsley-validate novalidate action="${pageContext.request.contextPath}/FindStudent" method="post">
					<p class="links">Please Enter your Student Number Below:<p/>
					
						
						<div class="form-group">
							
					</div>
                                           <label for="studentId" class="control-label sr-only">Student ID</label>
					<div class="form-group">
						<div class="input-group">
								<input type="text" placeholder="Student Number" id="studentId" name= "studentId"  class="form-control" required="required" autofocus pattern="^(N0|n0|P0|p0)+[A-Za-z0-9_]{2,15}$" title="The second character on your Student Number is Digit Zero ">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
							</div>
					</div>     
                                        <button class="btn btn-custom-primary btn-lg btn-block btn-auth"><i class="fa fa-arrow-circle-o-right"></i>Next</button>
				</form>
				<div class="links">
					
					<!--<p><a href="register.jsp">Create New Account</a></p>-->
				</div>
			</div>
		</div>
                                        <br/>
                                        <br/>
                                      <!-- <div class="footer1">&copy; 2017-2018 National University Of Science And Technology :: Think In Other Terms</div>-->
                                      <footer class="footer">&copy; 2019-2020 National University Of Science and Technology</footer>
	</div>
	<!--
	<!-- Javascript -->
	<script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/plugins/modernizr/modernizr.js"></script>
        <script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
        <script type="text/javascript" src ="birthdate.js"></script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/plugins/modernizr/modernizr.js"></script>
        <script src="assets/js/plugins/parsley-validation/parsley.min.js"></script>
        <script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="assets/js/bootstrap/bootstrap.js"></script>
	<script src="assets/js/plugins/modernizr/modernizr.js"></script>
	<script src="assets/js/plugins/bootstrap-tour/bootstrap-tour.custom.js"></script>
	<script src="assets/js/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/js/king-common.js"></script>
	<!--<script src="demo-style-switcher/assets/js/deliswitch.js"></script>-->
	
	
	
	

</body>
</html>
