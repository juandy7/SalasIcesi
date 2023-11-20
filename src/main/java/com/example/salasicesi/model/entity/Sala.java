package com.example.salasicesi.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Salas")
public class Sala {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String numSala;
    private String capacidad;
    private boolean estado;
    private String recursos;

    @OneToMany(mappedBy = "sala")
    @JsonIgnore
    private List<GestionSala> gestionesSala;


    @OneToMany(mappedBy = "sala")
    @JsonIgnore
    private List<SalasPorEdificio> salasPorEdificio;

    public List<SalasPorEdificio> getSalasPorEdificio() {
        return salasPorEdificio;
    }

    public void setSalasPorEdificio(List<SalasPorEdificio> salasPorEdificio) {
        this.salasPorEdificio = salasPorEdificio;
    }

    public List<GestionSala> getGestionesSala() {
        return gestionesSala;
    }

    public void setGestionesSala(List<GestionSala> gestionesSala) {
        this.gestionesSala = gestionesSala;
    }


    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }


    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

}
