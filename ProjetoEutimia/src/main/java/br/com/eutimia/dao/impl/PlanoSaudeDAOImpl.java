package main.java.br.com.eutimia.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import main.java.br.com.eutimia.dao.PlanoSaudeDAO;
import main.java.br.com.eutimia.model.PlanoSaudeDB;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("PlanoSaudeDAO")
@SuppressWarnings("unchecked")
public class PlanoSaudeDAOImpl implements PlanoSaudeDAO{

	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<PlanoSaudeDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(PlanoSaudeDB.class)
				.setFetchMode("planoSaude", FetchMode.JOIN);
		return criteria.list();
	}

	public List<PlanoSaudeDB> buscarPorNome(String nome) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PlanoSaudeDB.class);
		criteria.add(Restrictions.eq(PlanoSaudeDB.PLS_NM_NOME, nome));
		return criteria.list();
	}
	
	public PlanoSaudeDB buscarPorId(Integer consultaId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PlanoSaudeDB.class);
		criteria.add(Restrictions.eq(PlanoSaudeDB.PLS_ID, consultaId));
		ArrayList<PlanoSaudeDB> resultado = (ArrayList<PlanoSaudeDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<PlanoSaudeDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<PlanoSaudeDB> result = (List<PlanoSaudeDB>) query.list();
		return result;
	}

	public List<PlanoSaudeDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<PlanoSaudeDB> result = (List<PlanoSaudeDB>) query.list();
		return result;
	}

	public boolean inserir(PlanoSaudeDB planoSaudeDB) {
		Timestamp dataHoraOp = new Timestamp(System.currentTimeMillis());
		UUID uuid = UUID.randomUUID();
		
		planoSaudeDB.setaAudDhInclusao(dataHoraOp);
		planoSaudeDB.setaAudDhAlteraco(dataHoraOp);
		planoSaudeDB.setaPlanoSaudeUUID(uuid);
		
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(planoSaudeDB);
		return true;
	}

	public boolean atualizar(PlanoSaudeDB planoSaudeDB) {
		Timestamp dataHoraOp = new Timestamp(System.currentTimeMillis());
		UUID uuid = UUID.randomUUID();
		
		planoSaudeDB.setaAudDhAlteraco(dataHoraOp);
		planoSaudeDB.setaPlanoSaudeUUID(uuid);
		
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(planoSaudeDB);
		return true;
	}

	public boolean remover(PlanoSaudeDB planoSaudeDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(planoSaudeDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("planoSaudeDB.deleteById");
		
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