package main.java.br.com.eutimia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.TipoRelatorioDAO;
import main.java.br.com.eutimia.model.TipoRelatorioDB;
import main.java.br.com.eutimia.service.TipoRelatorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TipoRelatorioService")
@Transactional
public class TipoRelatorioServiceImpl implements TipoRelatorioService{
	
	@Autowired
	private TipoRelatorioDAO aTipoRelatorioDAO;

	public List<TipoRelatorioDB> buscarTodos() {
		return this.aTipoRelatorioDAO.buscarTodos();
	}
	
	public TipoRelatorioDB buscarPorId(Integer consultaId) {
		return this.aTipoRelatorioDAO.buscarPorId(consultaId);
	}

	public List<TipoRelatorioDB> findByNamedQuery(String name, Object... params) {
		return this.aTipoRelatorioDAO.findByNamedQuery(name, params);
	}

	public List<TipoRelatorioDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.aTipoRelatorioDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(TipoRelatorioDB consultaDB) {
		return this.aTipoRelatorioDAO.inserir(consultaDB);
	}

	public boolean atualizar(TipoRelatorioDB consultaDB) {
		return this.aTipoRelatorioDAO.atualizar(consultaDB);
	}

	public boolean remover(TipoRelatorioDB consultaDB) {
		return this.aTipoRelatorioDAO.remover(consultaDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoId) {
		return this.aTipoRelatorioDAO.removerPorId(colecaoId);
	}
}

