package main.java.br.com.eutimia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.br.com.eutimia.dao.MedicoDAO;
import main.java.br.com.eutimia.model.MedicoDB;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MedicoDAO")
@SuppressWarnings("unchecked")
public class MedicoDAOImpl implements MedicoDAO{
	
	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<MedicoDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MedicoDB.class);
		return criteria.list();
	}

	public List<MedicoDB> buscarPorNome(String nome) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MedicoDB.class);
		criteria.add(Restrictions.eq(MedicoDB.MED_NM_NOME, nome));
		return criteria.list();
	}
	
	public MedicoDB buscarPorId(Integer consultaId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MedicoDB.class);
		criteria.add(Restrictions.eq(MedicoDB.MED_ID, consultaId));
		ArrayList<MedicoDB> resultado = (ArrayList<MedicoDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<MedicoDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<MedicoDB> result = (List<MedicoDB>) query.list();
		return result;
	}

	public List<MedicoDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<MedicoDB> result = (List<MedicoDB>) query.list();
		return result;
	}

	public boolean inserir(MedicoDB medicoDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(medicoDB);
		return true;
	}

	public boolean atualizar(MedicoDB medicoDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(medicoDB);
		return true;
	}

	public boolean remover(MedicoDB medicoDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(medicoDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("medicoDB.deleteById");
		
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
