package main.java.br.com.eutimia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.PlanoSaudeDB;

public interface PlanoSaudeService {

	public List<PlanoSaudeDB> buscarTodos();
	
	public List<PlanoSaudeDB> buscarPorNome(String nome);
	
	public PlanoSaudeDB buscarPorId(Integer planoSaudeDBId);
	
	public List<PlanoSaudeDB> findByNamedQuery(final String name, Object... params);
	
	public List<PlanoSaudeDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(PlanoSaudeDB planoSaudeDB);
	
	public boolean atualizar(PlanoSaudeDB planoSaudeDB);
	
	public boolean remover(PlanoSaudeDB planoSaudeDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
}
