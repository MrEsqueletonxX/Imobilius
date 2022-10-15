package br.com.imobilius.controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.imobilius.model.Usuarios;

public class UsuariosDTO {
	private Long id;
	private String username;
	private String email;
	private LocalDateTime dataCriacao;

	public UsuariosDTO() {

	}

	public UsuariosDTO(Usuarios usuario) {
		this.id = usuario.getId();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.dataCriacao = usuario.getDataCriacao();
	}

	public static List<UsuariosDTO> converterLista(List<Usuarios> usuarios) {
		return usuarios.stream().map(UsuariosDTO::new).collect(Collectors.toList());
	}

	public UsuariosDTO converterImoveis(Usuarios usuario) {
		return new UsuariosDTO(usuario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
