package com.example.salasicesi.model.dto;
import com.example.salasicesi.model.dto.CategoriaDTO;
public class UsuarioDTO{

    private String nombre;
    private String email;
    private String contrasenha;
    private String codigo;
    private CategoriaDTO categoria;

    //ToDo: Hacer Getters y Setters


    public UsuarioDTO() {
    }

    public UsuarioDTO( String nombre, String email, String contrasenha, String codigo, CategoriaDTO categoria) {

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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }


}
