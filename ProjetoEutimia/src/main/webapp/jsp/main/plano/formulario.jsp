<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>Horizontal Forms - Stack Responsive Bootstrap 4 Admin Template</title>
    <link rel="apple-touch-icon" href="../../resources/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/vendors/css/extensions/pace.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/app.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/colors.min.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/core/menu/menu-types/vertical-menu-modern.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/core/menu/menu-types/vertical-overlay-menu.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/app-assets/css/core/colors/palette-gradient.min.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="../../resources/assets/css/style.css">
    <!-- END Custom CSS-->
  </head>
  <body data-open="click" data-menu="vertical-menu-modern" data-col="2-columns" class="vertical-layout vertical-menu-modern 2-columns   menu-expanded fixed-navbar">

    <!-- navbar-fixed-top-->
    <nav class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-dark navbar-shadow">
      <div class="navbar-wrapper">
        <div class="navbar-header">
          <ul class="nav navbar-nav">
            <li class="nav-item mobile-menu hidden-md-up float-xs-left"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu font-large-1"></i></a></li>
            <li class="nav-item"><a href="/ProjetoEutimia/index/index" class="navbar-brand"><img alt="stack admin logo" src="../../resources/app-assets/images/logo/stack-logo-light.png" class="brand-logo">
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
				<span class="avatar avatar-online"><img src="../../resources/app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span>
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
            <h3 class="content-header-title mb-0">Cadastro de Pacientes</h3>
            <div class="row breadcrumbs-top">
              <div class="breadcrumb-wrapper col-xs-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="/ProjetoEutimia/index/index">Home</a>
                  </li>
                  <li class="breadcrumb-item"><a href="/ProjetoEutimia/main/plano/home">Home Plano</a>
                  </li>
                  <li class="breadcrumb-item active"><a href="/ProjetoEutimia/main/plano/formulario">Cadastro de Planos de Saúde</a>
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <div class="content-body">
		<!-- Basic form layout section start -->
			<section id="horizontal-form-layouts">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="horz-layout-basic">Informações básicas</h4>
								<a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
										<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-body collapse in">
								<div class="card-block">
									<form:form id="planosaude" modelAttribute="planoSaudeDB" action="salvar" method="post" class="form form-horizontal">
										<div class="form-body">
											<h4 class="form-section"><i class="ft-user"></i> Informações básicas:</h4>
											<div class="form-group row">
												<label class="col-md-3 label-control" for="projectinput1">Nome do Plano</label>
												<div class="col-md-9">
													<form:input path="aPlanoSaudeNome" name="aPlanoSaudeNome" id="aPlanoSaudeNome" 
														type="text" class="form-control" placeholder="Nome do Plano"/>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control" for="timesheetinput3">Início de Vigência</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
														<form:input path="aPlanoSaudeDtInicioVigencia" name="aPlanoSaudeDtInicioVigencia" id="aPlanoSaudeDtInicioVigencia"
															type="date" class="form-control"/>
														<div class="form-control-position">
															<i class="ft-message-square"></i>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-md-3 label-control" for="timesheetinput3">Término de Vigência</label>
												<div class="col-md-9">
													<div class="position-relative has-icon-left">
														<form:input path="aPlanoSaudeDtFimVigencia" name="aPlanoSaudeDtFimVigencia" id="aPlanoSaudeDtFimVigencia"
														 	type="date" class="form-control"/>
														<div class="form-control-position">
															<i class="ft-message-square"></i>
														</div>
													</div>
												</div>
											</div>

										</div>

										<div class="form-actions">
											<button type="button" class="btn btn-warning mr-1">
												<i class="ft-x"></i> Cancel
											</button>
											<button type="submit" class="btn btn-primary">
												<i class="fa fa-check-square-o"></i> Save
											</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</section>
			<!-- // Basic form layout section end -->
        </div>
      </div>
    </div>

    <!-- BEGIN VENDOR JS-->
    <script src="../../resources/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="../../resources/app-assets/js/core/app-menu.min.js" type="text/javascript"></script>
    <script src="../../resources/app-assets/js/core/app.min.js" type="text/javascript"></script>
    <script src="../../resources/app-assets/js/scripts/customizer.min.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <!-- END PAGE LEVEL JS-->
  </body>
</html>