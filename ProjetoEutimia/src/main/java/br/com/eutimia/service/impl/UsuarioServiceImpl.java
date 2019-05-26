package main.java.br.com.eutimia.service.impl;

import main.java.br.com.eutimia.dao.UsuarioDAO;
import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.service.UsuarioService;
import main.java.br.com.eutimia.util.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UsuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final String SALT = "EUTIMIAPADDOCK_MD5_BASE";
	
	@Autowired
	private UsuarioDAO aUsuarioDAO;

	@Override
	public void register(UsuarioDB user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setaUsuarioSalt(SALT);
		user.setaUsuarioSenha(passwordEncoder.encode(user.getaUsuarioSenha()+SALT));
		this.aUsuarioDAO.inserir(user);
	}

	@Override
	public UsuarioDB validateUser(Login login) {
		UsuarioDB usuarioRegistrado = null;
		usuarioRegistrado = this.aUsuarioDAO.buscarPorAutenticacao(login);

		if (this.validarSenha(login.getPassword(),
				usuarioRegistrado.getaUsuarioSenha())) {
			return usuarioRegistrado;
		} else {
			return null;
		}
	}

	public boolean validarSenha(CharSequence senhaInformada, String senhaGravada) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(senhaInformada+UsuarioServiceImpl.SALT, senhaGravada)){
			return true;
		}else{
			return false;
		}
		
	}
}
