package main.java.br.com.eutimia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.PacienteDAO;
import main.java.br.com.eutimia.model.PacienteDB;
import main.java.br.com.eutimia.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PacienteService")
@Transactional
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteDAO pacienteDAO;
	
	public List<PacienteDB> buscarTodos() {
		return this.pacienteDAO.buscarTodos();
	}

	public List<PacienteDB> buscarPorNome(String name) {
		return this.pacienteDAO.buscarPorNome(name);
	}
	
	public PacienteDB buscarPorId(Integer consultaId) {
		return this.pacienteDAO.buscarPorId(consultaId);
	}

	public List<PacienteDB> findByNamedQuery(String name, Object... params) {
		return this.pacienteDAO.findByNamedQuery(name, params);
	}

	public List<PacienteDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.pacienteDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(PacienteDB pacienteDB) {
		return this.pacienteDAO.inserir(pacienteDB);
	}

	public boolean atualizar(PacienteDB pacienteDB) {
		return this.pacienteDAO.atualizar(pacienteDB);
	}

	public boolean remover(PacienteDB pacienteDB) {
		return this.pacienteDAO.remover(pacienteDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoIdPacientes){
		return this.pacienteDAO.removerPorId(colecaoIdPacientes);
	}
}
