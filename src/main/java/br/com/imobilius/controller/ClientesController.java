package br.com.imobilius.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobilius.controller.DTO.ClientesDTO;
import br.com.imobilius.controller.form.ClientesForm;
import br.com.imobilius.model.Clientes;
import br.com.imobilius.repository.ClientesRepository;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    
    @Autowired
    private ClientesRepository clienteRepo;
    
    @GetMapping("/listAll")
    @CrossOrigin("*")
    public List<ClientesDTO> listAll() {
        List<Clientes> listClientes = clienteRepo.findAll();
        return ClientesDTO.converterLista(listClientes);
    }
    
    @PostMapping("/cadastro")
    @Transactional
    public Clientes cadastrar(@RequestBody @Valid ClientesForm clienteForm) {
        Clientes cliente = clienteForm.converterClientesForm();
        return this.clienteRepo.save(cliente);
    }
    
}
