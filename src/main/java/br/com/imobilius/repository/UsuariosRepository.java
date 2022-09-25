package br.com.imobilius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imobilius.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
	
	
}