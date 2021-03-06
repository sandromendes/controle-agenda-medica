package main.java.br.com.eutimia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.model.MedicoDB;

public interface MedicoService {
	public List<MedicoDB> buscarTodos();
	
	public List<MedicoDB> buscarPorNome(String nome);
	
	public MedicoDB buscarPorId(Integer medicoId);
	
	public List<MedicoDB> findByNamedQuery(final String name, Object... params);
	
	public List<MedicoDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params);
	
	public boolean inserir(MedicoDB medicoDB);
	
	public boolean atualizar(MedicoDB medicoDB);
	
	public boolean remover(MedicoDB medicoDB);
	
	public boolean removerPorId(ArrayList<Integer> colecaoId);
}
