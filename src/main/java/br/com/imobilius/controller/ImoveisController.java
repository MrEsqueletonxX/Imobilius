package br.com.imobilius.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobilius.controller.DTO.ImoveisDTO;
import br.com.imobilius.controller.form.ImoveisForm;
import br.com.imobilius.model.Imoveis;
import br.com.imobilius.repository.ImoveisRepository;

@RestController
@RequestMapping("/imoveis")
public class ImoveisController {
	
	@Autowired
	ImoveisRepository imoveisRepo;
	
	@GetMapping("/listAll")
	public List<ImoveisDTO> listAll() {
		List<Imoveis> listImoveis = imoveisRepo.findAll();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listAllSimples")
	public List<ImoveisDTO> listAllSimples() {
		List<Imoveis> listImoveis = imoveisRepo.listAllImoveisResumida();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
//	@GetMapping("/listAllSimples")
//	public List<Imoveis> listAllSimples() {
//		List<Imoveis> listImoveis = imoveisRepo.listAllImoveisResumida();
//		return listImoveis;
//	}
	
//	@GetMapping("/listById/{id}")
//	public ResponseEntity<ImoveisDTO>
	
	@PostMapping("/cadastroImovel")
	public Imoveis cadastrarImovel(@RequestBody @Valid ImoveisForm imoveisForm) {
		Imoveis imoveis = imoveisForm.converterImoveisForm();
		return this.imoveisRepo.save(imoveis);
	}
	
	@DeleteMapping("/deleteById/{id}")
	@Transactional
	public void deleteById(@PathVariable("id") Long id) {
		this.imoveisRepo.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	@Transactional
	public void deleteAll() {
		this.imoveisRepo.deleteAll();
	}
	
}