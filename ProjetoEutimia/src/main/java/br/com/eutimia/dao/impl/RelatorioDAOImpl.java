package main.java.br.com.eutimia.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.RelatorioDAO;
import main.java.br.com.eutimia.model.ConsultaDB;
import main.java.br.com.eutimia.model.RelatorioDB;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("RelatorioDAO")
@SuppressWarnings("unchecked")
public class RelatorioDAOImpl implements RelatorioDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<RelatorioDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RelatorioDB.class);
		return criteria.list();
	}
	
	public RelatorioDB buscarPorId(Integer relatorioId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsultaDB.class);
		criteria.add(Restrictions.eq(ConsultaDB.CONS_ID, relatorioId));
		ArrayList<RelatorioDB> resultado = (ArrayList<RelatorioDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<RelatorioDB> buscarPorProtocolo(String protocolo) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RelatorioDB.class);
		criteria.add(Restrictions.eq(RelatorioDB.REL_PROTOCOLO, protocolo));
		return criteria.list();
	}

	public List<RelatorioDB> buscarPorTipoEData(Integer tipo, Date data) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RelatorioDB.class);
		criteria.add(Restrictions.eq(RelatorioDB.TPREL_ID, tipo));
		criteria.add(Restrictions.eq(RelatorioDB.REL_DT_GERACAO, data));
		return criteria.list();
	}
	
	public List<RelatorioDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<RelatorioDB> result = (List<RelatorioDB>) query.list();
		return result;
	}

	public List<RelatorioDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<RelatorioDB> result = (List<RelatorioDB>) query.list();
		return result;
	}

	public boolean inserir(RelatorioDB relatorioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(relatorioDB);
		return true;
	}

	public boolean atualizar(RelatorioDB relatorioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(relatorioDB);
		return true;
	}

	public boolean remover(RelatorioDB relatorioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(relatorioDB);
		return true;
	}

	public boolean removerPorId(ArrayList<Integer> colecaoId) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("relatorioDB.deleteById");
		
		if( colecaoId != null ){
			query.setParameterList("colecaoId", colecaoId);
			query.executeUpdate();
			return true;
		}
		else{
			return false;
		}
	}
}
