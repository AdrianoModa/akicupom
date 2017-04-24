package br.unifor.akicupom.bo;

import java.util.List;

import javax.ejb.EJB;

import br.unifor.akicupom.dao.EnderecoDAO;
import br.unifor.akicupom.model.Endereco;

public class EnderecoBO {

	@EJB
	private EnderecoDAO enderecoDAO;
	
	public void inserirNovoEndereco(Endereco endereco){
		enderecoDAO.salvar(endereco);
	}
	
	public void atualizarEndereco(Endereco endereco){
		enderecoDAO.atualizar(endereco);
	}
	
	public void removerEndereco(Endereco endereco){
		enderecoDAO.remover(endereco);
	}
	
	public Endereco buscarPorId(Long id){
		return enderecoDAO.buscarPorId(id);
	}
	
	public List<Endereco> listarEnderecos(){
		return enderecoDAO.buscarTodos();
	}
}

