package br.com.imobilius.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.imobilius.model.Usuarios;
import br.com.imobilius.repository.UsuariosRepository;

public class AtualizacaoUsuariosForm {
	@NotNull
	@NotEmpty
	@Length(min = 3)
	private String nome;
	@NotNull
	@NotEmpty
	@Length(min = 6)
	private String password;
	@NotNull
	@NotEmpty
	private String email;
	
	public Usuarios atualizar(Long id, UsuariosRepository usuariosRepo) {
		Usuarios usuario = usuariosRepo.getOne(id);
		usuario.setNome(nome);
		usuario.setSenha(password);
		usuario.setEmail(email);
		return usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return password;
	}

	public void setSenha(String senha) {
		this.password = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
