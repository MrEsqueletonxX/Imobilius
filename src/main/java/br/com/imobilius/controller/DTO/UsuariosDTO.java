package br.com.imobilius.controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.imobilius.model.Usuarios;

public class UsuariosDTO {
	private Long id;
	private String nome;
	private String email;
	//private LocalDateTime dataCriacao;

	public UsuariosDTO() {

	}

	public UsuariosDTO(Usuarios usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		//this.dataCriacao = usuario.getDataCriacao();
	}

	public static List<UsuariosDTO> converterLista(List<Usuarios> usuarios) {
		return usuarios.stream().map(UsuariosDTO::new).collect(Collectors.toList());
	}

	public UsuariosDTO converterImoveis(Usuarios usuario) {
		return new UsuariosDTO(usuario);
	}
	
	public Usuarios converterUsuario(Usuarios usuario) {
	    return new Usuarios(usuario.getEmail(), usuario.getSenha());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public LocalDateTime getDataCriacao() {
//		return dataCriacao;
//	}
//
//	public void setDataCriacao(LocalDateTime dataCriacao) {
//		this.dataCriacao = dataCriacao;
//	}

}
