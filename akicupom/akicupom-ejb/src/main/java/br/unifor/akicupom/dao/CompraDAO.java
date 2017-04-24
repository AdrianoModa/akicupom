package br.unifor.akicupom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.unifor.akicupom.model.Compra;

public class CompraDAO {

	private EntityManager em;

	public void salvar(Compra compra) {
		em.persist(compra);
	}

	public Compra atualizar(Compra compra) {
		return em.merge(compra);
	}

	public void remover(Compra compra) {
		em.persist(compra);
	}

	public Compra buscarPorId(Long id) {
		return em.find(Compra.class, id);
	}
	
	public List<Compra> buscarTodos(){
		String jpql = "Select c from Compra c";
		TypedQuery<Compra> query = em.createQuery(jpql, Compra.class);
		return query.getResultList();
		
	}

}
