package br.com.imobilius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imobilius.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	
	//public List<Categoria> findByIdcategoria(Long id);
	
}