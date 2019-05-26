package main.java.br.com.eutimia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.MedicoDAO;
import main.java.br.com.eutimia.model.MedicoDB;
import main.java.br.com.eutimia.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MedicoService")
@Transactional
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoDAO aMedicoDAO; 
	
	public List<MedicoDB> buscarTodos() {
		return this.aMedicoDAO.buscarTodos();
	}

	public List<MedicoDB> buscarPorNome(String nome) {
		return this.aMedicoDAO.buscarPorNome(nome);
	}

	public MedicoDB buscarPorId(Integer consultaId) {
		return this.aMedicoDAO.buscarPorId(consultaId);
	}

	public List<MedicoDB> findByNamedQuery(String name, Object... params) {
		return this.aMedicoDAO.findByNamedQuery(name, params);
	}

	public List<MedicoDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.aMedicoDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(MedicoDB consultaDB) {
		return this.aMedicoDAO.inserir(consultaDB);
	}

	public boolean atualizar(MedicoDB consultaDB) {
		return this.aMedicoDAO.atualizar(consultaDB);
	}

	public boolean remover(MedicoDB consultaDB) {
		return this.aMedicoDAO.remover(consultaDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoId) {
		return this.aMedicoDAO.removerPorId(colecaoId);
	}
}
