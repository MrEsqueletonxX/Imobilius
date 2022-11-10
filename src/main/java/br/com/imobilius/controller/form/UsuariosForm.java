package br.com.imobilius.controller.form;

import java.util.Optional;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.imobilius.model.Usuarios;

@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nome"),
                @UniqueConstraint(columnNames = "email")
        }
)
public class UsuariosForm {
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
	
	public Usuarios converterUsuariosForm() {
		return new Usuarios(nome, password, email);
	}
	
	public Usuarios converterUsuariosFormLogin() {
	    return new Usuarios(email, password);
	}
	
	public Optional<Usuarios> converterUsuariosFormOptional() {
        Optional<Usuarios> usuarios = new Usuarios(nome, password, email);
        
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
	    this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
}
