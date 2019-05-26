package main.java.br.com.eutimia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.TipoRelatorioDAO;
import main.java.br.com.eutimia.model.TipoRelatorioDB;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TipoRelatorioDAO")
@SuppressWarnings("unchecked")
public class TipoRelatorioDAOImpl implements TipoRelatorioDAO{

	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<TipoRelatorioDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoRelatorioDB.class);
		return criteria.list();
	}
	
	public TipoRelatorioDB buscarPorId(Integer tipoRelatorioId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoRelatorioDB.class);
		criteria.add(Restrictions.eq(TipoRelatorioDB.TPREL_ID, tipoRelatorioId));
		ArrayList<TipoRelatorioDB> resultado = (ArrayList<TipoRelatorioDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<TipoRelatorioDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<TipoRelatorioDB> result = (List<TipoRelatorioDB>) query.list();
		return result;
	}

	public List<TipoRelatorioDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<TipoRelatorioDB> result = (List<TipoRelatorioDB>) query.list();
		return result;
	}

	public boolean inserir(TipoRelatorioDB tipoRelatorioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(tipoRelatorioDB);
		return true;
	}

	public boolean atualizar(TipoRelatorioDB tipoRelatorioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(tipoRelatorioDB);
		return true;
	}

	public boolean remover(TipoRelatorioDB tipoRelatorioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(tipoRelatorioDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("tipoRelatorioDB.deleteById");
		
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
