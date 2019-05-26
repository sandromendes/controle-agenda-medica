package main.java.br.com.eutimia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.PacienteDB;

public interface PacienteDAO {

	public List<PacienteDB> buscarTodos();
	
	public List<PacienteDB> buscarPorNome(String name);
	
	public PacienteDB buscarPorId(Integer pacienteId);
	
	public List<PacienteDB> findByNamedQuery(final String name, Object... params);
	
	public List<PacienteDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(PacienteDB pacienteDB);
	
	public boolean atualizar(PacienteDB pacienteDB);
	
	public boolean remover(PacienteDB pacienteDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
	
}
