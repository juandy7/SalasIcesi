package com.example.salasicesi.model.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Edificios")
public class Edificio {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String edificioID;

    @OneToMany(mappedBy = "edificio")
    private List<SalasPorEdificio> salasPorEdificio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SalasPorEdificio> getSalasPorEdificio() {
        return salasPorEdificio;
    }

    public void setSalasPorEdificio(List<SalasPorEdificio> salasPorEdificio) {
        this.salasPorEdificio = salasPorEdificio;
    }

    public String getEdificioID() {
        return edificioID;
    }

    public void setEdificioID(String edificioID) {
        this.edificioID = edificioID;
    }
}
