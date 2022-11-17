package br.com.imobilius.controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.imobilius.model.Clientes;

public class ClientesDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;

    public ClientesDTO() {

    }

    public ClientesDTO(Clientes cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }
    
    public static List<ClientesDTO> converterLista(List<Clientes> clientes) {
        return clientes.stream()
                .map(ClientesDTO::new)
                .collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientesDTO other = (ClientesDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
