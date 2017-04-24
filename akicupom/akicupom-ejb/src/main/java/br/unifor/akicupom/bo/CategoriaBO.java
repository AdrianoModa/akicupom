package br.unifor.akicupom.bo;

import java.util.List;

import javax.ejb.EJB;

import br.unifor.akicupom.dao.CategoriaDAO;
import br.unifor.akicupom.model.Categoria;

public class CategoriaBO {
	
	@EJB
	private CategoriaDAO categoriaDAO;
	
	public void inserirNovaCategoria(Categoria categoria){
		categoriaDAO.salvar(categoria);
	}
	
	public void atualizarCategoria(Categoria categoria){
		categoriaDAO.atualizar(categoria);
	}
	
	public void removerCategoria(Categoria categoria){
		Categoria categoriaRemover = categoriaDAO.buscarPorId(categoria.getId());
		categoriaDAO.remover(categoriaRemover);
	}
	
	public Categoria buscarPorId(Long id){
		return categoriaDAO.buscarPorId(id);
	}
	
	public List<Categoria> listaCategoria(){
		return categoriaDAO.buscarTodos();
	}

}
