package main.java.br.com.eutimia.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	  @Override
	  public boolean preHandle(HttpServletRequest request, 
	      HttpServletResponse response, Object controller) throws Exception {

	      String uri = request.getRequestURI();
	      if(uri.endsWith("login") || uri.endsWith("logout") 
	    		  || uri.endsWith("registrar") || uri.endsWith("recuperar") 
	    		  || uri.endsWith("efetuarRegistro") || uri.endsWith("efetuarLogin")
	    		  || uri.contains("resources")){
	        return true;
	      }
	      
	      if(request.getSession().getAttribute(UsuarioDB._USUARIO_AUTENTICADO) != null) {
	        return true;
	      }
	      
	      response.sendRedirect("/ProjetoEutimia/login/login");
	      return false;
	  }
	}
