package br.com.imobilius.model;

import java.util.List;

public class UserManager {
    private String username;
    private String password;
    private String email;
    private List<Usuarios> listUsers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Usuarios> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Usuarios> listUsers) {
        this.listUsers = listUsers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
