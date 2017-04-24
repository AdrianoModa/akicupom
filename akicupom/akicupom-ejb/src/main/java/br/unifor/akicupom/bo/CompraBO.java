package br.unifor.akicupom.bo;

import java.util.List;

import javax.ejb.EJB;

import br.unifor.akicupom.dao.CompraDAO;
import br.unifor.akicupom.model.Compra;

public class CompraBO {

	@EJB
	private CompraDAO compraDAO;
	
	public void inserirNovaCompra(Compra compra){
		compraDAO.salvar(compra);
	}
	
	public void atualizar(Compra compra){
		compraDAO.atualizar(compra);
	}
	
	public void removerCompra(Compra compra){
		compraDAO.remover(compra);
	}
	
	public Compra buscarPorId(Long id){
		return compraDAO.buscarPorId(id);
	}
	
	public List<Compra> listaCompras(){
		return compraDAO.buscarTodos();
	}
}
