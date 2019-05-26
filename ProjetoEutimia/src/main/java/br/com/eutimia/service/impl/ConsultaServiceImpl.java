package main.java.br.com.eutimia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.ConsultaDAO;
import main.java.br.com.eutimia.model.ConsultaDB;
import main.java.br.com.eutimia.service.ConsultaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ConsultaService")
@Transactional
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaDAO aConsultaDAO;
	
	public List<ConsultaDB> buscarTodos() {
		return this.aConsultaDAO.buscarTodos();
	}

	public List<ConsultaDB> buscarPorProtocolo(String protocolo) {
		return this.aConsultaDAO.buscarPorProtocolo(protocolo);
	}

	public ConsultaDB buscarPorId(Integer consultaId) {
		return this.aConsultaDAO.buscarPorId(consultaId);
	}

	public List<ConsultaDB> findByNamedQuery(String name, Object... params) {
		return this.aConsultaDAO.findByNamedQuery(name, params);
	}

	public List<ConsultaDB> findByNamedQueryAndNamedParams(String name,
			Map<String, ? extends Object> params) {
		return this.aConsultaDAO.findByNamedQueryAndNamedParams(name, params);
	}

	public boolean inserir(ConsultaDB consultaDB) {
		return this.aConsultaDAO.inserir(consultaDB);
	}

	public boolean atualizar(ConsultaDB consultaDB) {
		return this.aConsultaDAO.atualizar(consultaDB);
	}

	public boolean remover(ConsultaDB consultaDB) {
		return this.aConsultaDAO.remover(consultaDB);
	}

	public boolean removerPorId(ArrayList<Integer> colecaoId) {
		return this.aConsultaDAO.removerPorId(colecaoId);
	}

}
