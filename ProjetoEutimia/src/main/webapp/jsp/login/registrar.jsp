<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  
<!-- Mirrored from pixinvent.com/stack-responsive-bootstrap-4-admin-template/html/ltr/vertical-modern-menu-template/register-simple.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 19 Sep 2017 10:33:50 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Register Page - Stack Responsive Bootstrap 4 Admin Template</title>
    <link rel="apple-touch-icon" href="../resources/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/vendors/css/extensions/pace.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/colors.min.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/core/menu/menu-types/vertical-menu-modern.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/core/colors/palette-gradient.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/app-assets/css/pages/login-register.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/style.css">
    <!-- END Custom CSS-->
  </head>
  <body data-open="click" data-menu="vertical-menu-modern" data-col="1-column" class="vertical-layout vertical-menu-modern 1-column   menu-expanded blank-page blank-page">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
    <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1 box-shadow-2 p-0">
		<div class="card border-grey border-lighten-3 px-2 py-2 m-0">
			<div class="card-header no-border">
				<div class="card-title text-xs-center">
					<img src="../resources/app-assets/images/logo/stack-logo-dark.png" alt="branding logo">
				</div>
				<h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span>Create Account</span></h6>
			</div>
			<div class="card-body collapse in">	
				<div class="card-block">
					<form:form id="login" modelAttribute="usuario" action="efetuarRegistro" method="post" class="form-horizontal form-simple" novalidate="novalidate">
						<fieldset class="form-group position-relative has-icon-left mb-1">
							<form:input path="aUsuarioLogin" name="aUsuarioLogin" id="aUsuarioLogin" 
								class="form-control form-control-lg input-lg" placeholder="User Name" required="required"/>
							<div class="form-control-position">
							    <i class="ft-user"></i>
							</div>
						</fieldset>
						<fieldset class="form-group position-relative has-icon-left mb-1">
							<form:input path="aUsuarioEmail" name="aUsuarioEmail" id="aUsuarioEmail" 
								class="form-control form-control-lg input-lg" placeholder="Your Email Address" required="required"/>
							<div class="form-control-position">
							    <i class="ft-mail"></i>
							</div>
						</fieldset>
						<fieldset class="form-group position-relative has-icon-left">
							<form:password path="aUsuarioSenha" name="aUsuarioSenha" id="aUsuarioSenha" 
								class="form-control form-control-lg input-lg" placeholder="Enter Password" required="required"/>
							<div class="form-control-position">
							    <i class="fa fa-key"></i>
							</div>
						</fieldset>
						<button type="submit" class="btn btn-primary btn-lg btn-block"><i class="ft-unlock"></i> Register</button>
					</form:form>
				</div>
				<p class="text-xs-center">Already have an account ? <a href="/ProjetoEutimia/login/login" class="card-link">Login</a></p>
			</div>
		</div>
	</div>
</section>
        </div>
      </div>
    </div>

    <!-- BEGIN VENDOR JS-->
    <script src="../resources/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../resources/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../resources/app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="../resources/app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="../resources/app-assets/js/scripts/customizer.min.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../resources/app-assets/js/scripts/forms/form-login-register.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  </body>

<!-- Mirrored from pixinvent.com/stack-responsive-bootstrap-4-admin-template/html/ltr/vertical-modern-menu-template/register-simple.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 19 Sep 2017 10:33:50 GMT -->
</html>