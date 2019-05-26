package main.java.br.com.eutimia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/index/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		UsuarioDB usuario = new UsuarioDB();
		usuario = (UsuarioDB) session.getAttribute(UsuarioDB._USUARIO_AUTENTICADO);
		ModelAndView mav = new ModelAndView("/index/index");
		mav.addObject(UsuarioDB._USUARIO_AUTENTICADO, usuario);
		return mav;
	}
	
	@RequestMapping(value = "/index/info", method = RequestMethod.GET)
	public ModelAndView info(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/index/info");
		return mav;
	}
	
}
