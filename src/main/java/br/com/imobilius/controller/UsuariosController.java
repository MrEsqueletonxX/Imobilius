package br.com.imobilius.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.imobilius.controller.DTO.UsuariosDTO;
import br.com.imobilius.controller.form.AtualizacaoUsuariosForm;
import br.com.imobilius.controller.form.UsuariosForm;
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
	@Transactional
	public ResponseEntity<UsuariosDTO> postUser(@RequestBody @Valid UsuariosForm userForm, UriComponentsBuilder uriBuilder) {
		Usuarios usuario = userForm.converterUsuariosForm();
	    userRepo.save(usuario);
	    
	    URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
	    return ResponseEntity.created(uri).body(new UsuariosDTO(usuario));
	}
	
	@PutMapping("/atualizarInformacoes/{id}")
	@Transactional
	public ResponseEntity<UsuariosDTO> updateUser(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuariosForm usuariosForm){
		Usuarios usuarios = usuariosForm.atualizar(id, userRepo);
		return ResponseEntity.ok(new UsuariosDTO(usuarios));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@Transactional
	public void deleteUser(@PathVariable Long id) {
		this.userRepo.deleteById(id);
	}
}
