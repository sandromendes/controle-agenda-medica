package main.java.br.com.eutimia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.TipoRelatorioDB;

public interface TipoRelatorioDAO {

	public List<TipoRelatorioDB> buscarTodos();
	
	public TipoRelatorioDB buscarPorId(Integer pacienteId);
	
	public List<TipoRelatorioDB> findByNamedQuery(final String name, Object... params);
	
	public List<TipoRelatorioDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(TipoRelatorioDB tipoRelatorioDB);
	
	public boolean atualizar(TipoRelatorioDB tipoRelatorioDB);
	
	public boolean remover(TipoRelatorioDB tipoRelatorioDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
}
