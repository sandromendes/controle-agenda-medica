package main.java.br.com.eutimia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.ConsultaDB;

public interface ConsultaDAO {

	public List<ConsultaDB> buscarTodos();
	
	public List<ConsultaDB> buscarPorProtocolo(String protocolo);
	
	public ConsultaDB buscarPorId(Integer consultaId);
	
	public List<ConsultaDB> findByNamedQuery(final String name, Object... params);
	
	public List<ConsultaDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(ConsultaDB consultaDB);
	
	public boolean atualizar(ConsultaDB consultaDB);
	
	public boolean remover(ConsultaDB consultaDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
}
