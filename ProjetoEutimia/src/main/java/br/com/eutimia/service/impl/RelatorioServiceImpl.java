package main.java.br.com.eutimia.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.RelatorioDAO;
import main.java.br.com.eutimia.model.RelatorioDB;
import main.java.br.com.eutimia.service.RelatorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RelatorioService")
@Transactional
public class RelatorioServiceImpl implements RelatorioService{

	@Autowired
	private RelatorioDAO aRelatorioDAO;
	
	public List<RelatorioDB> buscarTodos() {
		return this.aRelatorioDAO.buscarTodos();
	}

	public List<RelatorioDB> buscarPorTipoEData(Integer tipo, Date data) {
		return this.aRelatorioDAO.buscarPorTipoEData(tipo, data);
	}
	
	public RelatorioDB buscarPorId(Integer consultaId) {
		return this.aRelatorioDAO.buscarPorId(consultaId);
	}

	public List<RelatorioDB> findByNamedQuery(String name, Object... params) {
		return this.aRelatorioDAO.findByNamedQuery(name, params);
	}

	public List<RelatorioDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.aRelatorioDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(RelatorioDB consultaDB) {
		return this.aRelatorioDAO.inserir(consultaDB);
	}

	public boolean atualizar(RelatorioDB consultaDB) {
		return this.aRelatorioDAO.atualizar(consultaDB);
	}

	public boolean remover(RelatorioDB consultaDB) {
		return this.aRelatorioDAO.remover(consultaDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoId) {
		return this.aRelatorioDAO.removerPorId(colecaoId);
	}
}
