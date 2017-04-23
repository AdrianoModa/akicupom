package br.unifor.akicupom.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor_tb")
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 507283522956511789L;
	
	@Id
	@Column(name="fornecedor_id")
	private String cnpj;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String nomeFantasia;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private Endereco sede;
	
	@Column(nullable = false)
	private List<Endereco> filial;
	
}
