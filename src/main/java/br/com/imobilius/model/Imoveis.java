package br.com.imobilius.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.imobilius.controller.DTO.ImoveisDTO;

@Entity
@Table
public class Imoveis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_imovel")
	private Long idImovel;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_categoria")
	private Categoria categoria;

//	@ManyToOne
//	@Column(name = "cod_categoria")
//	private Categoria categoria;

	@Column(name = "nome_rua")
	private String nomeRua;

	@Column(name = "numero_imovel")
	private int numeroImovel;

	private String complemento;
	private String bairro;
	private String zona;
	private int quartos;
	private int banheiros;
	private boolean garagem;

	@Column(name = "area_total")
	private float areaTotal;

	@Column(name = "tipo_aquisicao")
	private String tipoAquisicao;

	@Column(name = "status_imovel")
	private String statusImovel;
	
	private float valor;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Imoveis() {
		
	}
	
	public Imoveis(Categoria categoria, String nomeRua, int numeroImovel, String complemento,
			String bairro, String zona, int quartos, int banheiros, boolean garagem, float areaTotal,
			String tipoAquisicao, String statusImovel, float valor) {
		super();
		this.categoria = categoria;
		this.nomeRua = nomeRua;
		this.numeroImovel = numeroImovel;
		this.complemento = complemento;
		this.bairro = bairro;
		this.zona = zona;
		this.quartos = quartos;
		this.banheiros = banheiros;
		this.garagem = garagem;
		this.areaTotal = areaTotal;
		this.tipoAquisicao = tipoAquisicao;
		this.statusImovel = statusImovel;
		this.valor = valor;
	}

	public Imoveis(ImoveisDTO imoveisDTO) {
		this.idImovel = imoveisDTO.getIdImovel();
		this.categoria = imoveisDTO.getCategoria();
		this.nomeRua = imoveisDTO.getNomeRua();
		this.numeroImovel = imoveisDTO.getNumeroImovel();
		this.complemento = imoveisDTO.getComplemento();
		this.bairro = imoveisDTO.getBairro();
		this.zona = imoveisDTO.getZona();
		this.quartos = imoveisDTO.getQuartos();
		this.banheiros = imoveisDTO.getBanheiros();
		this.garagem = imoveisDTO.isGaragem();
		this.areaTotal = imoveisDTO.getAreaTotal();
		this.tipoAquisicao = imoveisDTO.getTipoAquisicao();
		this.statusImovel = imoveisDTO.getStatusImovel();
		this.valor = imoveisDTO.getValor();
		this.dataCriacao = imoveisDTO.getDataCriacao();
	}

	public Long getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Long idImovel) {
		this.idImovel = idImovel;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public int getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(int numeroImovel) {
		this.numeroImovel = numeroImovel;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getQuartos() {
		return quartos;
	}

	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	public int getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}

	public boolean isGaragem() {
		return garagem;
	}

	public void setGaragem(boolean garagem) {
		this.garagem = garagem;
	}

	public float getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(float areaTotal) {
		this.areaTotal = areaTotal;
	}

	public String getTipoAquisicao() {
		return tipoAquisicao;
	}

	public void setTipoAquisicao(String tipoAquisicao) {
		this.tipoAquisicao = tipoAquisicao;
	}

	public String getStatusImovel() {
		return statusImovel;
	}

	public void setStatusImovel(String statusImovel) {
		this.statusImovel = statusImovel;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idImovel == null) ? 0 : idImovel.hashCode());
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
		Imoveis other = (Imoveis) obj;
		if (idImovel == null) {
			if (other.idImovel != null)
				return false;
		} else if (!idImovel.equals(other.idImovel))
			return false;
		return true;
	}

}