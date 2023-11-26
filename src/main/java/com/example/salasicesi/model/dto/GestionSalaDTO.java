package com.example.salasicesi.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class GestionSalaDTO {

    private LocalTime hora;
    private LocalDate dia;
    private long idUsuario;
    private long idSala;
    private String correoUsuario;

    public GestionSalaDTO() {
    }

    public GestionSalaDTO(LocalTime hora, LocalDate dia, long idUsuario, long idSala, String correoUsuario) {
        this.hora = hora;
        this.dia = dia;
        this.idUsuario = idUsuario;
        this.idSala = idSala;
        this.correoUsuario = correoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }
}
