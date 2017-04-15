package br.unifor.akicupom.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity(name = "tb_compra")
public class Compra implements Serializable {

	

	private static final long serialVersionUID = -1852404237680053196L;
	
	@Id
	@Column(name = "compra_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
	@Column(nullable=false)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cupom> cupom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Cupom> getCupom() {
		return cupom;
	}

	public void setCupom(List<Cupom> cupom) {
		this.cupom = cupom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cupom == null) ? 0 : cupom.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Compra other = (Compra) obj;
		if (cupom == null) {
			if (other.cupom != null)
				return false;
		} else if (!cupom.equals(other.cupom))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", date=" + data + ", usuario=" + usuario + ", cupom=" + cupom + "]";
	}
}
