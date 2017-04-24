package br.unifor.akicupom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.unifor.akicupom.model.Endereco;

public class EnderecoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Endereco endereco){
		em.persist(endereco);
	}
	
	public Endereco atualizar(Endereco endereco){
		return em.merge(endereco);
	}
	
	public void remover(Endereco endereco){
		em.remove(endereco);
	}
	
	public Endereco buscarPorId(Long id){
		return em.find(Endereco.class, id);
	}
	
	public List<Endereco> buscarTodos(){
		String jpql = "select e from Endereco e";
		TypedQuery<Endereco> query = em.createQuery(jpql, Endereco.class);
		return query.getResultList();
		
	}

}
