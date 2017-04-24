package br.unifor.akicupom.bo;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.akicupom.dao.UsuarioDAO;
import br.unifor.akicupom.model.Usuario;

@Stateless
public class UsuarioBO {
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	public void inserirNovoUsuario(Usuario usuario){
		usuarioDAO.salvar(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario){
		usuarioDAO.atualizar(usuario);
	}
	
	public void removerUsuario(Usuario usuario){
		Usuario usuarioRemover = usuarioDAO.buscarPorId(usuario.getId());
		usuarioDAO.remover(usuarioRemover);
	}
	
	public Usuario buscarPorId(Long id){
		return usuarioDAO.buscarPorId(id);
	}
	
	public List<Usuario> listaUsuarios(){
		return usuarioDAO.buscarTodos();
	}

}
