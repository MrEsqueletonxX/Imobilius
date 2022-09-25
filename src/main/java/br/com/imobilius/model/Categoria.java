package br.com.imobilius.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_categoria")
	private Long idCategoria;
	
//	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Imoveis> idImovel;

	private String titulo;
	private String descricao;
	
	public Categoria() {
		
	}
	
	public Categoria(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

//	public List<Imoveis> getImoveis() {
//		return idImovel;
//	}
//
//	public void setImoveis(List<Imoveis> imoveis) {
//		this.idImovel = imoveis;
//	}

//	public Imoveis getImoveis() {
//		return imoveis;
//	}
//
//	public void setImoveis(Imoveis imoveis) {
//		this.imoveis = imoveis;
//	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		return true;
	}
	
	
}
