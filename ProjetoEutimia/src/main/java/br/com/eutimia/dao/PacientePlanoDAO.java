package main.java.br.com.eutimia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.PacientePlanoDB;

public interface PacientePlanoDAO {

	public List<PacientePlanoDB> buscarTodos();
	
	public PacientePlanoDB buscarPorId(Integer pacienteId);
	
	public List<PacientePlanoDB> findByNamedQuery(final String name, Object... params);
	
	public List<PacientePlanoDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(PacientePlanoDB pacientePlanoDB);
	
	public boolean atualizar(PacientePlanoDB pacientePlanoDB);
	
	public boolean remover(PacientePlanoDB pacientePlanoDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
}
