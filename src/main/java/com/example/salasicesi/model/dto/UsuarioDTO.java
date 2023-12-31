package com.example.salasicesi.model.dto;
import com.example.salasicesi.model.entity.Categoria;

public class UsuarioDTO{

    private String nombre;
    private String email;
    private String contrasenha;
    private String codigo;
    private Categoria categoria;

    //ToDo: Hacer Getters y Setters



    public UsuarioDTO(String nombre, String email, String contrasenha, String codigo, Categoria categoria) {

        this.nombre = nombre;
        this.email = email;
        this.contrasenha = contrasenha;
        this.codigo = codigo;
        this.categoria = categoria;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
