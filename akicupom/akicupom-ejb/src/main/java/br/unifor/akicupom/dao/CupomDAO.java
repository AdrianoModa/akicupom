package br.unifor.akicupom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.unifor.akicupom.model.Cupom;
import br.unifor.akicupom.model.Usuario;

public class CupomDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Cupom cupom){
		em.persist(cupom);
	}
	
	public Cupom atualizar(Cupom cupom){
		return em.merge(cupom);
	}
	
	public void remover(Cupom cupom){
		em.remove(cupom);
	}
	
	public Cupom buscarPorId(Long id){
		return em.find(Cupom.class, id);
	}
	
	public List<Cupom> buscarTodos(){
		String jpql = "select c from Cupom c";
		TypedQuery<Cupom> query = em.createQuery(jpql, Cupom.class);
		return query.getResultList();
		
	}
}
