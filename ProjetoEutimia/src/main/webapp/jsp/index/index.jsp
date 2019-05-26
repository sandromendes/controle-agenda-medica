<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>EUTIMIA - Controle de Consultas</title>
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
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/style.css">
    <!-- END Custom CSS-->
  </head>
  <body data-open="click" data-menu="vertical-menu-modern" data-col="2-columns" class="vertical-layout vertical-menu-modern 2-columns   menu-expanded fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="/ProjetoEutimia/index/index" class="navbar-brand"><img alt="stack admin logo" src="../resources/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
                <h2 class="brand-text">EUTIMIA</h2></a></li>
            <li class="nav-item hidden-sm-down float-xs-right"><a data-toggle="collapse" class="nav-link modern-nav-toggle"><i data-ticon="ft-toggle-right" class="toggle-icon ft-toggle-right font-medium-3 white"></i></a></li>
            <li class="nav-item hidden-md-up float-xs-right"><a data-toggle="collapse" data-target="#navbar-mobile" class="nav-link open-navbar-container"><i class="fa fa-ellipsis-v"></i></a></li>
          </ul>
        </div>
        <div class="navbar-container content container-fluid">
          <div id="navbar-mobile" class="collapse navbar-toggleable-sm">
          <form:form id="formInfoUsuario" method="POST" action="info">
            <ul class="nav navbar-nav float-xs-right">
              <li class="dropdown dropdown-user nav-item"><a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link dropdown-user-link">
				<span class="avatar avatar-online"><img src="../resources/app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span>
					<span class="user-name">${usuarioAutenticado.aUsuarioNome}</span></a>
                <div class="dropdown-menu dropdown-menu-right">
					<a href="#" class="dropdown-item"><i class="ft-user"></i> Edit Profile</a>
						<a href="#" class="dropdown-item"><i class="ft-mail"></i> My Inbox</a>
						<a href="#" class="dropdown-item"><i class="ft-check-square"></i> Task</a>
						<a href="#" class="dropdown-item"><i class="ft-message-square"></i> Chats</a>
                <div class="dropdown-divider"></div>
					<a href="/ProjetoEutimia/login/logout" class="dropdown-item"><i class="ft-power"></i> Logout</a>
                </div>
              </li>
            </ul>
            </form:form>
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <div data-scroll-to-active="true" class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
      <div class="main-menu-content">
        <ul id="main-menu-navigation" data-menu="menu-navigation" class="navigation navigation-main">
          <li class=" navigation-header"><span>Menu</span><i data-toggle="tooltip" data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-layers"></i><span data-i18n="" class="menu-title">Plano de Saúde</span></a>
            <ul class="menu-content">
			  <li><a href="/ProjetoEutimia/main/plano/home" class="menu-item">Home</a>
              </li>
              <li><a href="/ProjetoEutimia/main/plano/formulario" class="menu-item">Formulário</a>
              </li>
              <li><a href="/ProjetoEutimia/main/plano/pesquisa" class="menu-item">Listagem</a>
              </li>
            </ul>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-layers"></i><span data-i18n="" class="menu-title">Paciente</span></a>
            <ul class="menu-content">
              <li><a href="gallery-grid.html" class="menu-item">Gallery Grid</a>
              </li>
              <li><a href="gallery-grid-with-desc.html" class="menu-item">Gallery Grid with Desc</a>
              </li>
              <li><a href="gallery-masonry.html" class="menu-item">Masonry Gallery</a>
              </li>
              <li><a href="gallery-masonry-with-desc.html" class="menu-item">Masonry Gallery with Desc</a>
              </li>
              <li><a href="gallery-hover-effects.html" class="menu-item">Hover Effects</a>
              </li>
            </ul>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-layers"></i><span data-i18n="" class="menu-title">Médico</span></a>
            <ul class="menu-content">
              <li><a href="search-page.html" class="menu-item">Search Page</a>
              </li>
              <li><a href="search-website.html" class="menu-item">Search Website</a>
              </li>
              <li><a href="search-images.html" class="menu-item">Search Images</a>
              </li>
              <li><a href="search-videos.html" class="menu-item">Search Videos</a>
              </li>
            </ul>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-plus-square"></i><span data-i18n="" class="menu-title">Consulta</span></a>
            <ul class="menu-content">
              <li><a href="search-page.html" class="menu-item">Search Page</a>
              </li>
              <li><a href="search-website.html" class="menu-item">Search Website</a>
              </li>
              <li><a href="search-images.html" class="menu-item">Search Images</a>
              </li>
              <li><a href="search-videos.html" class="menu-item">Search Videos</a>
              </li>
            </ul>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-printer"></i><span data-i18n="" class="menu-title">Relatórios</span></a>
            <ul class="menu-content">
              <li><a href="search-page.html" class="menu-item">Search Page</a>
              </li>
              <li><a href="search-website.html" class="menu-item">Search Website</a>
              </li>
              <li><a href="search-images.html" class="menu-item">Search Images</a>
              </li>
              <li><a href="search-videos.html" class="menu-item">Search Videos</a>
              </li>
            </ul>
          </li>
          <li class=" nav-item"><a href="#"><i class="ft-edit"></i><span data-i18n="" class="menu-title">Adm. do Sistema</span></a>
            <ul class="menu-content">
              <li><a href="search-page.html" class="menu-item">Search Page</a>
              </li>
              <li><a href="search-website.html" class="menu-item">Search Website</a>
              </li>
              <li><a href="search-images.html" class="menu-item">Search Images</a>
              </li>
              <li><a href="search-videos.html" class="menu-item">Search Videos</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>

    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-xs-12 mb-2">
            <h3 class="content-header-title mb-0">Início</h3>
          </div>
        </div>
        <div class="content-body">
        
			<div class="row">
			    <div class="col-xl-3 col-lg-6 col-xs-12">
			        <div class="card">
			            <div class="card-body">
			                <div class="media">
			                    <div class="p-2 text-xs-center bg-primary bg-darken-2 media-left media-middle">
			                        <i class="icon-camera font-large-2 white"></i>
			                    </div>
			                    <div class="p-2 bg-gradient-x-primary white media-body">
			                        <h5>Products</h5>
			                        <h5 class="text-bold-400"><i class="ft-plus"></i> 28</h5>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			    <div class="col-xl-3 col-lg-6 col-xs-12">
			        <div class="card">
			            <div class="card-body">
			                <div class="media">
			                    <div class="p-2 text-xs-center bg-danger bg-darken-2 media-left media-middle">
			                        <i class="icon-user font-large-2 white"></i>
			                    </div>
			                    <div class="p-2 bg-gradient-x-danger white media-body">
			                        <h5>New Users</h5>
			                        <h5 class="text-bold-400"><i class="ft-arrow-up"></i>1,238</h5>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			    <div class="col-xl-3 col-lg-6 col-xs-12">
			        <div class="card">
			            <div class="card-body">
			                <div class="media">
			                    <div class="p-2 text-xs-center bg-warning bg-darken-2 media-left media-middle">
			                        <i class="icon-basket-loaded font-large-2 white"></i>
			                    </div>
			                    <div class="p-2 bg-gradient-x-warning white media-body">
			                        <h5>New Orders</h5>
			                        <h5 class="text-bold-400"><i class="ft-arrow-down"></i> 4,658</h5>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			    <div class="col-xl-3 col-lg-6 col-xs-12">
			        <div class="card">
			            <div class="card-body">
			                <div class="media">
			                    <div class="p-2 text-xs-center bg-success bg-darken-2 media-left media-middle">
			                        <i class="icon-wallet font-large-2 white"></i>
			                    </div>
			                    <div class="p-2 bg-gradient-x-success white media-body">
			                        <h5>Total Profit</h5>
			                        <h5 class="text-bold-400"><i class="ft-arrow-up"></i> 5.6 M</h5>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
			
			<div class="col-md-8 offset-md-2 col-lg-6 offset-lg-3">
			    <div class="px-2 py-3 row mb-0 mt-3">
			        <fieldset class="form-group position-relative">
			            <input type="text" class="form-control form-control-lg input-lg" id="iconLeft" placeholder="Pesquisa Geral ...">
			            <div class="form-control-position">
			                <i class="ft-mic font-medium-4"></i>
			            </div>
			        </fieldset>
			        <div class="row py-2">
			            <div class="col-xs-12 text-xs-center">
			                <a href="search-website.html" class="btn btn-primary btn-md"><i class="ft-search"></i> Buscar</a>
			            </div>
			        </div>
			    </div>
	        </div>
      </div>
    </div>

    <!-- BEGIN VENDOR JS-->
    <script src="../resources/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../resources/app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="../resources/app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="../resources/app-assets/js/scripts/customizer.min.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- END PAGE LEVEL JS-->
  </body>
</html>