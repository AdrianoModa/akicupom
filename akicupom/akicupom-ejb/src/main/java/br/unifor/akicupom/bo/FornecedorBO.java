package br.unifor.akicupom.bo;

import java.util.List;

import javax.ejb.EJB;

import br.unifor.akicupom.dao.FornecedorDAO;
import br.unifor.akicupom.model.Fornecedor;

public class FornecedorBO {

	@EJB
	private FornecedorDAO fornecedorDAO;
	
	public void inserirNovoFornecedor(Fornecedor fornecedor){
		fornecedorDAO.salvar(fornecedor);
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor){
		fornecedorDAO.atualizar(fornecedor);
	}
	
	public void removerFornecedor(Fornecedor fornecedor){
		fornecedorDAO.remover(fornecedor);
	}
	
	public Fornecedor buscarPorId(Long id){
		return fornecedorDAO.buscarPorId(id);
	}
	
	public List<Fornecedor> listaFornecedores(){
		return fornecedorDAO.buscarTodos();
	}
	
}
