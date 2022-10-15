package br.com.imobilius.controller.form;

import javax.validation.constraints.NotNull;

import br.com.imobilius.model.Categoria;
import br.com.imobilius.model.Imoveis;
import br.com.imobilius.repository.ImoveisRepository;

public class AtualizacaoImoveisForm {
	@NotNull
	private Categoria categoria;
	@NotNull
	private String nomeRua;
	@NotNull
	private int numeroImovel;
	private String complemento;
	@NotNull
	private String bairro;
	@NotNull
	private String zona;
	@NotNull
	private int quartos;
	@NotNull
	private int banheiros;
	@NotNull
	private boolean garagem;
	@NotNull
	private float areaTotal;
	@NotNull
	private String tipoAquisicao;
	@NotNull
	private String statusImovel;
	@NotNull
	private float valor;
	
	public Imoveis atualizar(Long idImoveis, ImoveisRepository imoveisRepo) {
		Imoveis imoveis = imoveisRepo.getOne(idImoveis);
		imoveis.setNomeRua(nomeRua);
		imoveis.setNumeroImovel(numeroImovel);
		imoveis.setComplemento(complemento);
		imoveis.setBairro(bairro);
		imoveis.setZona(zona);
		imoveis.setQuartos(quartos);
		imoveis.setBanheiros(banheiros);
		imoveis.setGaragem(garagem);
		imoveis.setAreaTotal(areaTotal);
		imoveis.setTipoAquisicao(tipoAquisicao);
		imoveis.setStatusImovel(statusImovel);
		imoveis.setValor(valor);
		return imoveis;
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
	
}
