package main.java.br.com.eutimia.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import main.java.br.com.eutimia.dao.UsuarioDAO;
import main.java.br.com.eutimia.model.autenticacao.UsuarioDB;
import main.java.br.com.eutimia.util.Login;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UsuarioDAO")
@SuppressWarnings("unchecked")
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@Autowired	
	private SessionFactory sessionFactory;
	
	public List<UsuarioDB> buscarTodos() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UsuarioDB.class);
		return criteria.list();
	}
	
	public UsuarioDB buscarPorId(Integer usuarioId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UsuarioDB.class);
		criteria.add(Restrictions.eq(UsuarioDB.USR_ID, usuarioId));
		ArrayList<UsuarioDB> resultado = (ArrayList<UsuarioDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}
	}
	
	public UsuarioDB buscarPorAutenticacao(Login login){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UsuarioDB.class);
		criteria.add(Restrictions.like("aUsuarioLogin", login.getUsername()));
		criteria.uniqueResult();
		ArrayList<UsuarioDB> resultado = (ArrayList<UsuarioDB>) criteria.list();
		if(!resultado.isEmpty()){
			return resultado.get(0);			
		}else{
			return null;
		}		
	}

	public List<UsuarioDB> findByNamedQuery(final String name, Object... params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		final List<UsuarioDB> result = (List<UsuarioDB>) query.list();
		return result;
	}

	public List<UsuarioDB> findByNamedQueryAndNamedParams(final String name,
			final Map<String, ? extends Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		final List<UsuarioDB> result = (List<UsuarioDB>) query.list();
		return result;
	}

	public boolean inserir(UsuarioDB usuarioDB) {
		Timestamp dataHoraOp = new Timestamp(System.currentTimeMillis());
		UUID uuid = UUID.randomUUID();
		
		usuarioDB.setaAudDhInclusao(dataHoraOp);
		usuarioDB.setaAudDhAlteraco(dataHoraOp);
		usuarioDB.setaUsuarioUUID(uuid);
		
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(usuarioDB);
		return true;
	}

	public boolean atualizar(UsuarioDB usuarioDB) {
		Timestamp dataHoraOp = new Timestamp(System.currentTimeMillis());
		UUID uuid = UUID.randomUUID();
		
		usuarioDB.setaAudDhInclusao(dataHoraOp);
		usuarioDB.setaAudDhAlteraco(dataHoraOp);
		usuarioDB.setaUsuarioUUID(uuid);		
		
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(usuarioDB);
		return true;
	}

	public boolean remover(UsuarioDB usuarioDB) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(usuarioDB);
		return true;
	}
	
	public boolean removerPorId(ArrayList<Integer> colecaoId){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("usuarioDB.deleteById");
		
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
