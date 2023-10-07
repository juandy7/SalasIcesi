package com.example.salasicesi.model.dto;

public class SalaDTO {

    private String numSala;
    private String token;
    private String capacidad;
    private boolean estado;
    private String recursos;


    public SalaDTO() {
    }

    public SalaDTO(String numSala, String token, String capacidad, boolean estado, String recursos) {
        this.numSala = numSala;
        this.token = token;
        this.capacidad = capacidad;
        this.estado = estado;
        this.recursos = recursos;
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
