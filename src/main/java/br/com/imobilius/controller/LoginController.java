package br.com.imobilius.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobilius.controller.form.UsuariosFormLogin;
import br.com.imobilius.model.Usuarios;
import br.com.imobilius.repository.UsuariosRepository;

@RestController
public class LoginController {
    
    @Autowired
    private UsuariosRepository userRepo;
    
    @PostMapping("/login")
    @Transactional
    @CrossOrigin("*")
    public ResponseEntity<Usuarios> login(@RequestBody @Valid UsuariosFormLogin userForm) {
        Optional<Usuarios> user = userRepo.findByEmailAndSenha(userForm.getEmail(), userForm.getPassword());
        if(user.isPresent()) {
            Usuarios usuario = user.get();
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
        
    }
    
}
