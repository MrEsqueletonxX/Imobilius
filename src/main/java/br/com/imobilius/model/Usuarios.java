package br.com.imobilius.model;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_user")
	private Long id;
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Imoveis> imoveis;
//	@ManyToMany(fetch = FetchType.EAGER)
//    private List<Perfil> perfis = new ArrayList<>();
//	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	private String nome;
	private String password;
	private String email;
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Usuarios() {

	}

	public Usuarios(String nome, String senha, String email) {
		super();
		this.nome = nome;
		this.password = senha;
		this.email = email;
	}
	
	public Usuarios(String email, String senha) {
	    this.email = email;
	    this.password = senha;
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

//	public List<Imoveis> getImoveis() {
//		return imoveis;
//	}
//
//	public void setImoveis(List<Imoveis> imoveis) {
//		this.imoveis = imoveis;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuarios other = (Usuarios) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}