package br.com.imobilius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobilius.controller.DTO.UsuariosDTO;
import br.com.imobilius.model.Usuarios;
import br.com.imobilius.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	UsuariosRepository userRepo;
	
	@GetMapping("/listAll")
	public List<UsuariosDTO> listAll() {
		List<Usuarios> listUsuarios = userRepo.findAll();
		return UsuariosDTO.converterLista(listUsuarios);
	}
	
	@PostMapping("/cadastro")
	public Usuarios postUser(@RequestBody Usuarios user) {
		return this.userRepo.save(user);
	}
}
