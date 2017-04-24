package br.unifor.akicupom.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unifor.akicupom.bo.CompraBO;
import br.unifor.akicupom.model.Compra;

@RequestScoped
@Path("/akicupom/compra")
public class CompraResource {
	
	@Inject
	private CompraBO compraBO;
	
	@GET
	@Path("/compra/listacompras")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCompras(){
		List<Compra> compras = compraBO.listaCompras();
		return Response.ok(compras).build();
	}

}
