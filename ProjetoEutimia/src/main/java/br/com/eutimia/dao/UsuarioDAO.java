package main.java.br.com.eutimia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.util.Login;

public interface UsuarioDAO {
	
	public List<UsuarioDB> buscarTodos();
	
	public UsuarioDB buscarPorId(Integer usuarioId);
	
	public UsuarioDB buscarPorAutenticacao(Login login);
	
	public List<UsuarioDB> findByNamedQuery(final String name, Object... params);
	
	public List<UsuarioDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(UsuarioDB usuarioDB);
	
	public boolean atualizar(UsuarioDB usuarioDB);
	
	public boolean remover(UsuarioDB usuarioDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);

}
