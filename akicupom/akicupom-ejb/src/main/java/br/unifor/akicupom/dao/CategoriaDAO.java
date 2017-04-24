package br.unifor.akicupom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.unifor.akicupom.model.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;

	public void salvar(Categoria categoria) {
		em.persist(categoria);
	}

	public Categoria atualizar(Categoria categoria) {
		return em.merge(categoria);
	}

	public void remover(Categoria categoria) {
		em.persist(categoria);
	}

	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}
	
	public List<Categoria> buscarTodos(){
		String jpql = "Select c from Categoria c";
		TypedQuery<Categoria> query = em.createQuery(jpql, Categoria.class);
		return query.getResultList();
		
	}

}
