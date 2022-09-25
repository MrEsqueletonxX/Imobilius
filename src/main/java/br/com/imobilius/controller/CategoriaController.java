package br.com.imobilius.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobilius.model.Categoria;
import br.com.imobilius.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	List<Categoria> listCategorias = new ArrayList();
	
	@Autowired
	CategoriaRepository categoriaRepo;
	
	@GetMapping("/listAll")
	public List<Categoria> listAll() {
		System.out.println(listCategorias.toString());
		return this.categoriaRepo.findAll();
	}
	
	@PostMapping("/post")
	public Categoria post(@RequestBody Categoria categoria) {
		return this.categoriaRepo.save(categoria);
	}
	
	@PostMapping("/postAll")
	public List<Categoria> postAll(@RequestBody List<Categoria> categoria) {
		categoria.addAll(listCategorias);
		return (List<Categoria>) this.categoriaRepo.saveAll(categoria);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.categoriaRepo.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void delete() {
		this.categoriaRepo.deleteAll();
	}
}