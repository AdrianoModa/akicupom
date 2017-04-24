package br.unifor.akicupom.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.unifor.akicupom.model.Usuario;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Usuario usuario){
		em.persist(usuario);
	}
	
	public Usuario atualizar(Usuario usuario){
		return em.merge(usuario);
	}
	
	public void remover(Usuario usuario){
		em.remove(usuario);
	}
	
	public Usuario buscarPorId(Long id){
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarTodos(){
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		return query.getResultList();
		
	}
}
