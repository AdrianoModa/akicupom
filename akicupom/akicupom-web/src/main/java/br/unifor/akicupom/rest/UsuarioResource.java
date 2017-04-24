package br.unifor.akicupom.rest;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unifor.akicupom.bo.UsuarioBO;
import br.unifor.akicupom.model.Usuario;

@RequestScoped
@Path("/akicupom/usuario")
public class UsuarioResource {
	
	@Inject
	private UsuarioBO usuarioBO;
	
	@GET
	@Path("/usuario/listausuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuarios(){
		List<Usuario> usuarios = usuarioBO.listaUsuarios();
		return Response.ok(usuarios).build();
		
	}
	@GET
	@Path("/usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarUsuario(@PathParam("id") Long id){
		Usuario usuario = usuarioBO.buscarPorId(id);
		if(usuario == null){
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return Response.ok(usuario).build();
	}
	
	@POST
	@Path("/usuario/{nome}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response novoUsuario(@PathParam("nome") String nome, @PathParam("email") String email){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuarioBO.inserirNovoUsuario(usuario);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/usuario/{id}")
	public Response atualizarUsuario(@PathParam("id") Long id, Usuario usuario){
		Usuario usuarioExistente = usuarioBO.buscarPorId(id);
		if(usuarioExistente == null){
			throw new WebApplicationException(Status.NOT_MODIFIED);
		}
		usuarioExistente.setNome(usuario.getNome());
		usuarioExistente.setEmail(usuario.getEmail());
		usuarioBO.atualizarUsuario(usuarioExistente);		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/usuario/{id}")
	public Response deletarUsuario(@PathParam("id") Long id){
		Usuario usuario = usuarioBO.buscarPorId(id);
		if(usuario == null){
			throw new WebApplicationException(Status.NOT_MODIFIED);
		}
		usuarioBO.removerUsuario(usuario);
		return Response.ok().build();
	}

}
