package br.unifor.akicupom.entitys;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cupom_tb")
public class Cupom implements Serializable{

	private static final long serialVersionUID = 684217561641765192L;
	
	@Id
	@Column(name="cupom_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Categoria cat;
	
	@Column(nullable = false)
	private Fornecedor fornecedor;
	
	@Column(nullable = false)
	private Calendar datePost;
	
	@Column(nullable = false)
	private Calendar dataVenda;
	
	@Column(nullable = false)
	private Usuario usuario;
	
	@Column(nullable = false)
	private List<Endereco> lojaParticipante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Calendar getDatePost() {
		return datePost;
	}

	public void setDatePost(Calendar datePost) {
		this.datePost = datePost;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Endereco> getLojaParticipante() {
		return lojaParticipante;
	}

	public void setLojaParticipante(List<Endereco> lojaParticipante) {
		this.lojaParticipante = lojaParticipante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupom other = (Cupom) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}


