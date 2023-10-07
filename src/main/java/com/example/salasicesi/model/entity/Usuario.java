package com.example.salasicesi.model.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nombre;
    private String email;
    private String contrasenha;
    private String codigo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "usuario")
    private List<GestionSala> gestionSalas;

    public List<GestionSala> getGestionSalas() {
        return gestionSalas;
    }

    public void setGestionSalas(List<GestionSala> gestionSalas) {
        this.gestionSalas = gestionSalas;
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
