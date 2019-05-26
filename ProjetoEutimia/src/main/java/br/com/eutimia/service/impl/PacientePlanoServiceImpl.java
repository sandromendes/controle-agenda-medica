package main.java.br.com.eutimia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.PacientePlanoDAO;
import main.java.br.com.eutimia.model.PacientePlanoDB;
import main.java.br.com.eutimia.service.PacientePlanoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PacientePlanoService")
@Transactional
public class PacientePlanoServiceImpl implements PacientePlanoService{

	@Autowired
	private PacientePlanoDAO aPacientePlanoDAO;

	public List<PacientePlanoDB> buscarTodos() {
		return this.aPacientePlanoDAO.buscarTodos();
	}
	
	public PacientePlanoDB buscarPorId(Integer pacientePlanoId) {
		return this.aPacientePlanoDAO.buscarPorId(pacientePlanoId);
	}

	public List<PacientePlanoDB> findByNamedQuery(String name, Object... params) {
		return this.aPacientePlanoDAO.findByNamedQuery(name, params);
	}

	public List<PacientePlanoDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.aPacientePlanoDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(PacientePlanoDB pacientePlanoDB) {
		return this.aPacientePlanoDAO.inserir(pacientePlanoDB);
	}

	public boolean atualizar(PacientePlanoDB pacientePlanoDB) {
		return this.aPacientePlanoDAO.atualizar(pacientePlanoDB);
	}

	public boolean remover(PacientePlanoDB pacientePlanoDB) {
		return this.aPacientePlanoDAO.remover(pacientePlanoDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoId) {
		return this.aPacientePlanoDAO.removerPorId(colecaoId);
	}
}
