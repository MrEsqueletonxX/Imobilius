package br.com.imobilius.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.imobilius.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
	Optional<Usuarios> findByEmail(String email);
	
	Usuarios findByPassword(String Password);
	
	@Query("select u from Usuarios u where u.email = :email and u.password = :password")
	Optional<Usuarios> findByEmailAndSenha(@Param("email") String email, @Param("password") String password);
	
}