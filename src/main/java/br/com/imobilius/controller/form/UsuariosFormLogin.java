package br.com.imobilius.controller.form;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.imobilius.model.Usuarios;

@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class UsuariosFormLogin {
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    @Length(min = 6)
    private String password;

    public Usuarios converterUsuariosForm() {
        return new Usuarios(email, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
