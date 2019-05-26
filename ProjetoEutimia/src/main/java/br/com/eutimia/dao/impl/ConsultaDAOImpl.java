package main.java.br.com.eutimia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import main.java.br.com.eutimia.dao.ConsultaDAO;
import main.java.br.com.eutimia.model.ConsultaDB;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ConsultaDAO")
@SuppressWarnings("unchecked")
public class ConsultaDAOImpl implements ConsultaDAO{
	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<ConsultaDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsultaDB.class);
		return criteria.list();
	}

	public List<ConsultaDB> buscarPorProtocolo(String protocolo) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsultaDB.class);
		criteria.add(Restrictions.eq(ConsultaDB.CONS_NU_PROTOCOLO_DIA, protocolo));
		return criteria.list();
	}
	
	public ConsultaDB buscarPorId(Integer consultaId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ConsultaDB.class);
		criteria.add(Restrictions.eq(ConsultaDB.CONS_ID, consultaId));
		ArrayList<ConsultaDB> resultado = (ArrayList<ConsultaDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<ConsultaDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<ConsultaDB> result = (List<ConsultaDB>) query.list();
		return result;
	}

	public List<ConsultaDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<ConsultaDB> result = (List<ConsultaDB>) query.list();
		return result;
	}

	public boolean inserir(ConsultaDB consultaDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(consultaDB);
		return true;
	}

	public boolean atualizar(ConsultaDB consultaDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(consultaDB);
		return true;
	}

	public boolean remover(ConsultaDB consultaDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(consultaDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("consultaDB.deleteById");
		
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
