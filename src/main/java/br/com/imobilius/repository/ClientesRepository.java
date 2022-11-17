package br.com.imobilius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imobilius.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    
    
}
