package br.unifor.akicupom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.unifor.akicupom.model.Fornecedor;

public class FornecedorDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Fornecedor fornecedor){
		em.persist(fornecedor);
	}
	
	public Fornecedor atualizar(Fornecedor fornecedor){
		return em.merge(fornecedor);
	}
	
	public void remover(Fornecedor fornecedor){
		em.remove(fornecedor);
	}
	
	public Fornecedor buscarPorId(Long id){
		return em.find(Fornecedor.class, id);
	}
	
	public List<Fornecedor> buscarTodos(){
		String jpql = "select f from Fornecedor f";
		TypedQuery<Fornecedor> query = em.createQuery(jpql, Fornecedor.class);
		return query.getResultList();
		
	}

}