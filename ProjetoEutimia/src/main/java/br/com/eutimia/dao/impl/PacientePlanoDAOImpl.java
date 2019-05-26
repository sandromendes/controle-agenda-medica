package main.java.br.com.eutimia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.PacientePlanoDAO;
import main.java.br.com.eutimia.model.PacientePlanoDB;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("PacientePlanoDAO")
@SuppressWarnings("unchecked")
public class PacientePlanoDAOImpl implements PacientePlanoDAO{

	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<PacientePlanoDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PacientePlanoDB.class);
		return criteria.list();
	}
	
	public PacientePlanoDB buscarPorId(Integer consultaId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PacientePlanoDB.class);
		criteria.add(Restrictions.eq(PacientePlanoDB.PAC_ID, consultaId));
		ArrayList<PacientePlanoDB> resultado = (ArrayList<PacientePlanoDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<PacientePlanoDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<PacientePlanoDB> result = (List<PacientePlanoDB>) query.list();
		return result;
	}

	public List<PacientePlanoDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<PacientePlanoDB> result = (List<PacientePlanoDB>) query.list();
		return result;
	}

	public boolean inserir(PacientePlanoDB pacientePlanoDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(pacientePlanoDB);
		return true;
	}

	public boolean atualizar(PacientePlanoDB pacientePlanoDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(pacientePlanoDB);
		return true;
	}

	public boolean remover(PacientePlanoDB pacientePlanoDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(pacientePlanoDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("pacientePlanoDB.deleteById");
		
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
