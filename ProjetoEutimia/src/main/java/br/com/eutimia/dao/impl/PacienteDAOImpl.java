package main.java.br.com.eutimia.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import main.java.br.com.eutimia.dao.PacienteDAO;
import main.java.br.com.eutimia.model.PacienteDB;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("PacienteDAO")
@SuppressWarnings("unchecked")
public class PacienteDAOImpl implements PacienteDAO{

	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<PacienteDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PacienteDB.class);
		return criteria.list();
	}

	public List<PacienteDB> buscarPorNome(String nome) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PacienteDB.class);
		criteria.add(Restrictions.eq(PacienteDB.PAC_NM_NOME, nome));
		return criteria.list();
	}
	
	public PacienteDB buscarPorId(Integer consultaId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PacienteDB.class);
		criteria.add(Restrictions.eq(PacienteDB.PAC_ID, consultaId));
		ArrayList<PacienteDB> resultado = (ArrayList<PacienteDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}

	public List<PacienteDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<PacienteDB> result = (List<PacienteDB>) query.list();
		return result;
	}

	public List<PacienteDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<PacienteDB> result = (List<PacienteDB>) query.list();
		return result;
	}

	public boolean inserir(PacienteDB pacienteDB) {
		Timestamp dataHoraOp = new Timestamp(System.currentTimeMillis());
		UUID uuid = UUID.randomUUID();
		
		pacienteDB.setaAudDhInclusao(dataHoraOp);
		pacienteDB.setaAudDhAlteraco(dataHoraOp);
		pacienteDB.setaPacienteUUID(uuid);
		
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(pacienteDB);
		return true;
	}

	public boolean atualizar(PacienteDB pacienteDB) {
		Timestamp dataHoraOp = new Timestamp(System.currentTimeMillis());
		UUID uuid = UUID.randomUUID();
		
		pacienteDB.setaAudDhAlteraco(dataHoraOp);
		pacienteDB.setaPacienteUUID(uuid);
		
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(pacienteDB);
		return true;
	}

	public boolean remover(PacienteDB pacienteDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(pacienteDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("pacienteDB.deleteById");
		
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
