package main.java.br.com.eutimia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistroUsuarioController {
	@Autowired
	public UsuarioService usuarioService;

	@RequestMapping(value = "/login/registrar", method = RequestMethod.GET)
	public ModelAndView registrar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/login/registrar");
		mav.addObject("usuario", new UsuarioDB());
		return mav;
	}

	@RequestMapping(value = "/login/efetuarRegistro", method = RequestMethod.POST)
	public ModelAndView efetuarRegistro(HttpServletRequest request,	HttpServletResponse response,
			@ModelAttribute("usuario") UsuarioDB usuario) {
		this.usuarioService.register(usuario);
		return new ModelAndView("/index/index", "nomeUsuario", usuario.getaUsuarioNome());
	}
}
