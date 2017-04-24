package br.unifor.akicupom.bo;

import java.util.List;

import javax.ejb.EJB;

import br.unifor.akicupom.dao.CupomDAO;
import br.unifor.akicupom.model.Cupom;

public class CupomBO {

	@EJB
	private CupomDAO cupomDAO;
	
	public void inserirNovoCupom(Cupom cupom){
		cupomDAO.salvar(cupom);
	}
	
	public void atualizarCupom(Cupom cupom){
		cupomDAO.atualizar(cupom);
	}
	
	public void removerCupom(Cupom cupom){
		Cupom cupomRemover = cupomDAO.buscarPorId(cupom.getId());
		cupomDAO.remover(cupomRemover);
	}
	
	public Cupom buscarPorId(Long id){
		return cupomDAO.buscarPorId(id);
	}
	
	public List<Cupom> listaCupons(){
		return cupomDAO.buscarTodos();
	}


}
