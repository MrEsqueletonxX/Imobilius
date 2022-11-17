package br.com.imobilius.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobilius.controller.DTO.ImoveisDTO;
import br.com.imobilius.controller.form.AtualizacaoImoveisForm;
import br.com.imobilius.controller.form.ImoveisForm;
import br.com.imobilius.model.Imoveis;
import br.com.imobilius.model.interfaces.ImoveisApartamento;
import br.com.imobilius.model.interfaces.ImoveisApartamentoAlugando;
import br.com.imobilius.model.interfaces.ImoveisApartamentoAluguelDisponivel;
import br.com.imobilius.model.interfaces.ImoveisApartamentoVendendo;
import br.com.imobilius.model.interfaces.ImoveisApartamentoVendidos;
import br.com.imobilius.model.interfaces.ImoveisCasa;
import br.com.imobilius.model.interfaces.ImoveisCasaAlugando;
import br.com.imobilius.model.interfaces.ImoveisCasaAluguelDisponivel;
import br.com.imobilius.model.interfaces.ImoveisCasaVendendo;
import br.com.imobilius.model.interfaces.ImoveisCasaVendidos;
import br.com.imobilius.model.interfaces.ImoveisView;
import br.com.imobilius.model.interfaces.MediaValorApartamentosPorBairro;
import br.com.imobilius.model.interfaces.MediaValorBairro;
import br.com.imobilius.model.interfaces.MediaValorCasasPorBairro;
import br.com.imobilius.model.interfaces.MediaValorZona;
import br.com.imobilius.model.interfaces.QuantidadePorBairro;
import br.com.imobilius.model.interfaces.QuantidadePorZona;
import br.com.imobilius.repository.ImoveisRepository;

@RestController
@RequestMapping("/imoveis")
@CrossOrigin("*")
public class ImoveisController {
	
	@Autowired
	private ImoveisRepository imoveisRepo;
	
	@GetMapping("/listAll")
	@CrossOrigin("*")
	public List<ImoveisDTO> listAll() {
		List<Imoveis> listImoveis = imoveisRepo.findAll();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listAllSimples")
	public List<ImoveisView> listAllSimples() {
		List<ImoveisView> listImoveis = imoveisRepo.listAllImoveisResumida();
		return listImoveis;
	}
	
	@GetMapping("/listByBairro/{bairro}")
	public List<ImoveisDTO> listByBairro(@PathVariable("bairro") String bairro) {
		List<Imoveis> listImoveis = imoveisRepo.findByBairro(bairro);
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listByZona/{zona}")
	public List<ImoveisDTO> listByZona(@PathVariable("zona") String zona) {
		List<Imoveis> listImoveis = imoveisRepo.findByZona(zona);
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listImoveisCasa")
	public List<ImoveisCasa> listCasas() {
		List<ImoveisCasa> listImoveis = imoveisRepo.listImoveisCasa();
		return listImoveis;
	}
	
	@GetMapping("/listImoveisApartamento")
	public List<ImoveisApartamento> listApartamentos() {
		List<ImoveisApartamento> listImoveis = imoveisRepo.listImoveisApartamento();
		return listImoveis;
	}
	
	@GetMapping("/quantidadePorBairro")
	public List<QuantidadePorBairro> listByQuantidadePorBairro() {
		List<QuantidadePorBairro> listImoveis = imoveisRepo.quantidadePorBairro();
		return listImoveis;
	}
	
	@GetMapping("/quantidadePorZona")
	public List<QuantidadePorZona> listByQuantidadePorZona() {
		List<QuantidadePorZona> listImoveis = imoveisRepo.quantidadePorZona();
		return listImoveis;
	}
	
	@GetMapping("/quantidadeQuartos/{quartos}")
	public List<ImoveisDTO> listImoveisByQuartos(@PathVariable("quartos") int quartos) {
		List<Imoveis> listImoveis = imoveisRepo.findByQuartos(quartos);
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/quantidadeBanheiros/{banheiros}")
	public List<ImoveisDTO> listImoveisByBanheiro(@PathVariable("banheiros") int banheiros) {
		List<Imoveis> listImoveis = imoveisRepo.findByBanheiros(banheiros);
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listImoveisByGaragem/{garagem}")
	public List<ImoveisDTO> listImoveisByGaragem(@PathVariable("garagem") boolean garagem) {
		List<Imoveis> listImoveis = imoveisRepo.findByGaragem(garagem);
		return ImoveisDTO.converterLista(listImoveis);
	}
	
//	@GetMapping("/quantidadeQuartosBanheiros/{quartos}/{banheiros}")
//	public List<ImoveisDTO> listImoveisByQuartos(@PathVariable("quartos, banheiros") int quartos, int banheiros) {
//		List<Imoveis> listImoveis = imoveisRepo.findByQuartosBanheiros(quartos, banheiros);
//		return ImoveisDTO.converterLista(listImoveis);
//	}
	
	@GetMapping("/listImoveisStatusVendidos")
	public List<ImoveisDTO> listImoveisVendidos() {
		List<Imoveis> listImoveis = imoveisRepo.findImoveisVendidos();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listImoveisCasaStatusVendidos")
	public List<ImoveisCasaVendidos>  listImoveisCasaVendidos() {
	    List<ImoveisCasaVendidos> listImoveis = imoveisRepo.findImoveisCasaVendidos();
	    return listImoveis;
	}
	
	@GetMapping("/listImoveisApartamentoStatusVendidos")
    public List<ImoveisApartamentoVendidos>  listImoveisApartamentoVendidos() {
        List<ImoveisApartamentoVendidos> listImoveis = imoveisRepo.findImoveisApartamentoVendidos();
        return listImoveis;
    }
	
	@GetMapping("/listImoveisStatusVendese")
	public List<ImoveisDTO> listImoveisVendese() {
		List<Imoveis> listImoveis = imoveisRepo.findImoveisVendendo();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listImoveisCasaStatusVendese")
    public List<ImoveisCasaVendendo> listImoveisCasaVendese() {
        List<ImoveisCasaVendendo> listImoveis = imoveisRepo.findImoveisCasaVendendo();
        return listImoveis;
    }
	
	@GetMapping("/listImoveisApartamentoStatusVendese")
    public List<ImoveisApartamentoVendendo> listImoveisApartamentoVendese() {
        List<ImoveisApartamentoVendendo> listImoveis = imoveisRepo.findImoveisApartamentoVendendo();
        return listImoveis;
    }
	
	@GetMapping("/listImoveisStatusAluguelDisponivel")
	public List<ImoveisDTO> listImoveisAlugase() {
		List<Imoveis> listImoveis = imoveisRepo.findImoveisAluguelDisponivel();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listImoveisCasaStatusAluguelDisponivel")
    public List<ImoveisCasaAluguelDisponivel> listImoveisCasaAlugase() {
        List<ImoveisCasaAluguelDisponivel> listImoveis = imoveisRepo.findImoveisCasaAluguelDisponivel();
        return listImoveis;
    }
	
	@GetMapping("/listImoveisApartamentoStatusAluguelDisponivel")
    public List<ImoveisApartamentoAluguelDisponivel> listImoveisApartamentoAlugase() {
        List<ImoveisApartamentoAluguelDisponivel> listImoveis = imoveisRepo.findImoveisApartamentoAluguelDisponivel();
        return listImoveis;
    }
	
	@GetMapping("/listImoveisStatusAlugando")
	public List<ImoveisDTO> listImoveisAlugando() {
		List<Imoveis> listImoveis = imoveisRepo.findImoveisAluguelAlugando();
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/listImoveisCasaStatusAlugando")
    public List<ImoveisCasaAlugando> listImoveisCasaAlugando() {
        List<ImoveisCasaAlugando> listImoveis = imoveisRepo.findImoveisCasaAluguelAlugando();
        return listImoveis;
    }
	
	@GetMapping("/listImoveisApartamentoStatusAlugando")
    public List<ImoveisApartamentoAlugando> listImoveisApartamentoAlugando() {
        List<ImoveisApartamentoAlugando> listImoveis = imoveisRepo.findImoveisApartamentoAluguelAlugando();
        return listImoveis;
    }
	
	@GetMapping("/mediaValorBairro")
	public List<MediaValorBairro> mediaValorBairro() {
		List<MediaValorBairro> listImoveis = imoveisRepo.mediaValorBairro();
		return listImoveis;
	}
	
	@GetMapping("/mediaValorCasasBairro")
    public List<MediaValorCasasPorBairro> mediaValorCasasBairro() {
        List<MediaValorCasasPorBairro> listImoveis = imoveisRepo.mediaValorCasasPorBairro();
        return listImoveis;
    }
	
	@GetMapping("/mediaValorApartamentosBairro")
    public List<MediaValorApartamentosPorBairro> mediaValorApartamentosBairro() {
        List<MediaValorApartamentosPorBairro> listImoveis = imoveisRepo.mediaValorApartamentosPorBairro();
        return listImoveis;
    }
	
	@GetMapping("/mediaValorZona")
	public List<MediaValorZona> mediaValorZona() {
		List<MediaValorZona> listImoveis = imoveisRepo.mediaValorZona();
		return listImoveis;
	}
	
	@GetMapping("/listImovelById/{idImovel}")
	public List<ImoveisDTO> listImovelById(@PathVariable Long idImovel) {
		List<Imoveis> listImoveis = imoveisRepo.findByIdImovel(idImovel);
		return ImoveisDTO.converterLista(listImoveis);
	}
	
	@GetMapping("/disponibilidadeImoveis")
	public List<ImoveisDTO> listDisponibilidadeImoveisPorBairro(@RequestBody String bairro) {
	    List<Imoveis> listImoveis = imoveisRepo.findDisponibilidadeImoveisPorBairro(bairro);
	    return ImoveisDTO.converterLista(listImoveis);
	}
	
	@PostMapping("/cadastroImovel")
	@Transactional
	public Imoveis cadastrarImovel(@RequestBody @Valid ImoveisForm imoveisForm) {
		Imoveis imoveis = imoveisForm.converterImoveisForm();
		return this.imoveisRepo.save(imoveis);
	}
	
	@PutMapping("/atualizarInformacoes/{idImovel}")
	@Transactional
	public ResponseEntity<ImoveisDTO> updateImovel(@PathVariable Long idImovel, @RequestBody @Valid AtualizacaoImoveisForm imoveisForm) {
		//Optional<Imoveis> optional = imoveisRepo.findById(idImovel);
		Imoveis imoveis = imoveisForm.atualizar(idImovel, imoveisRepo);
		return ResponseEntity.ok(new ImoveisDTO(imoveis));
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