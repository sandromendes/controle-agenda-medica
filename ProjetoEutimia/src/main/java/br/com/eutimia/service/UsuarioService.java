package main.java.br.com.eutimia.service;

import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.util.Login;

public interface UsuarioService {
	
	  public void register(UsuarioDB user);
	
	  public UsuarioDB validateUser(Login login);
}
