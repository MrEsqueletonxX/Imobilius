package br.com.imobilius.controller.form;

import br.com.imobilius.model.Clientes;

public class ClientesForm {
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    
    public Clientes converterClientesForm() {
        return new Clientes(nome, sobrenome, email, telefone);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
