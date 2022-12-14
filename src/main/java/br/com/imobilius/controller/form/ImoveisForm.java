package br.com.imobilius.controller.form;

import java.time.LocalDateTime;

import br.com.imobilius.model.Categoria;
import br.com.imobilius.model.Imoveis;

public class ImoveisForm {
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
	
	public Imoveis converterImoveisForm() {
		return new Imoveis(categoria, nomeRua, numeroImovel, complemento, bairro, zona,
				quartos, banheiros, garagem, areaTotal, tipoAquisicao, statusImovel, valor, dataCriacao);
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