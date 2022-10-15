package br.com.imobilius.controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.imobilius.model.Categoria;
import br.com.imobilius.model.Imoveis;

public class ImoveisDTO {
	private Long idImovel;
	private Categoria categoria;
	private String nomeRua;
	private int numeroImovel;
	private String complemento;
	private String bairro;
	private String zona;
	private int quartos;
	private int banheiros;
	private boolean garagem;
	private float areaTotal;
	private String tipoAquisicao;
	private String statusImovel;
	private float valor;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public ImoveisDTO() {
		
	}

	public ImoveisDTO(Imoveis imoveis) {
		this.idImovel = imoveis.getIdImovel();
		this.categoria = imoveis.getCategoria();
		this.nomeRua = imoveis.getNomeRua();
		this.numeroImovel = imoveis.getNumeroImovel();
		this.complemento = imoveis.getComplemento();
		this.bairro = imoveis.getBairro();
		this.zona = imoveis.getZona();
		this.quartos = imoveis.getQuartos();
		this.banheiros = imoveis.getBanheiros();
		this.garagem = imoveis.isGaragem();
		this.areaTotal = imoveis.getAreaTotal();
		this.tipoAquisicao = imoveis.getTipoAquisicao();
		this.valor = imoveis.getValor();
		this.statusImovel = imoveis.getStatusImovel();
		this.dataCriacao = imoveis.getDataCriacao();
	}
	
	public static List<ImoveisDTO> converterLista(List<Imoveis> imoveis){
		return imoveis.stream()
				.map(ImoveisDTO::new)
				.collect(Collectors.toList());
	}
	
//	public static Optional<ImoveisDTO> converterOptional(List<Imoveis> imoveis){
//		return imoveis.stream()
//				.map(ImoveisDTO::new)
//				.collect(Collectors.toList());
//	}
	
	public ImoveisDTO converterImoveis(Imoveis imoveis) {
		return new ImoveisDTO(imoveis);
	}

	public Long getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Long idImovel) {
		this.idImovel = idImovel;
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

	public void setStatus(String statusImovel) {
		this.statusImovel = statusImovel;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		ImoveisDTO other = (ImoveisDTO) obj;
		if (idImovel == null) {
			if (other.idImovel != null)
				return false;
		} else if (!idImovel.equals(other.idImovel))
			return false;
		return true;
	}

}
