package main.java.br.com.eutimia.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.service.UsuarioService;
import main.java.br.com.eutimia.util.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	UsuarioService userService;

	@RequestMapping(value = "/login/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/login/login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/login/efetuarLogin", method = RequestMethod.POST)
	public ModelAndView efetuarLogin(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("login") Login login,
			HttpSession session) throws IOException {
		ModelAndView model = null;
		UsuarioDB usuario = userService.validateUser(login);
		if (null != usuario) {
			session.setAttribute(UsuarioDB._USUARIO_AUTENTICADO, usuario);
			model = new ModelAndView("redirect:/index/index");
		} else {
			model = new ModelAndView("/login/login");
			model.addObject("message", "Usuário ou senha inválidos!!");
		}
		return model;
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:/login/login";
	}
}