package main.java.br.com.eutimia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.PlanoSaudeDAO;
import main.java.br.com.eutimia.model.PlanoSaudeDB;
import main.java.br.com.eutimia.service.PlanoSaudeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PlanoSaudeService")
@Transactional
public class PlanoSaudeServiceImpl implements PlanoSaudeService{

	@Autowired
	private PlanoSaudeDAO planoSaudeDAO;
	
	public List<PlanoSaudeDB> buscarTodos() {
		return this.planoSaudeDAO.buscarTodos();
	}

	public List<PlanoSaudeDB> buscarPorNome(String name) {
		return this.planoSaudeDAO.buscarPorNome(name);
	}
	
	public PlanoSaudeDB buscarPorId(Integer consultaId) {
		return this.planoSaudeDAO.buscarPorId(consultaId);
	}

	public List<PlanoSaudeDB> findByNamedQuery(String name, Object... params) {
		return this.planoSaudeDAO.findByNamedQuery(name, params);
	}

	public List<PlanoSaudeDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.planoSaudeDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(PlanoSaudeDB pacienteDB) {
		return this.planoSaudeDAO.inserir(pacienteDB);
	}

	public boolean atualizar(PlanoSaudeDB pacienteDB) {
		return this.planoSaudeDAO.atualizar(pacienteDB);
	}

	public boolean remover(PlanoSaudeDB pacienteDB) {
		return this.planoSaudeDAO.remover(pacienteDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoIdPacientes){
		return this.planoSaudeDAO.removerPorId(colecaoIdPacientes);
	}
}
