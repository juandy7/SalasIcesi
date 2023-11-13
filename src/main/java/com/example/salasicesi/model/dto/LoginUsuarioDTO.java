package com.example.salasicesi.model.dto;

public class LoginUsuarioDTO {


    private long id;
    private String email;
    private String contrasenha;

    public LoginUsuarioDTO() {
    }

    public LoginUsuarioDTO(long id, String email, String contrasenha) {
        this.id = id;
        this.email = email;
        this.contrasenha = contrasenha;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}
