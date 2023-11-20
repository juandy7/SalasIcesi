package com.example.salasicesi.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class MisReservasDTO {
    private LocalTime hora;
    private LocalDate dia;
    private String numSala;
    private String token;

    public MisReservasDTO() {
    }

    public MisReservasDTO(LocalTime hora, LocalDate dia, String numSala, String token) {
        this.hora = hora;
        this.dia = dia;
        this.numSala = numSala;
        this.token = token;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
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
}
