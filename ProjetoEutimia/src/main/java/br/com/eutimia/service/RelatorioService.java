package main.java.br.com.eutimia.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.RelatorioDB;

public interface RelatorioService {

	public List<RelatorioDB> buscarTodos();
	
	public List<RelatorioDB> buscarPorTipoEData(Integer tipo, Date data);
	
	public RelatorioDB buscarPorId(Integer relatorioDBId);
	
	public List<RelatorioDB> findByNamedQuery(final String name, Object... params);
	
	public List<RelatorioDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(RelatorioDB relatorioDB);
	
	public boolean atualizar(RelatorioDB relatorioDB);
	
	public boolean remover(RelatorioDB relatorioDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
}
