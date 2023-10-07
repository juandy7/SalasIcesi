package com.example.salasicesi.model.dto;

public class EdificioDTO {
    private String edificioID;

    public EdificioDTO() {
    }

    public EdificioDTO(String edificioID) {
        this.edificioID = edificioID;
    }


    public String getEdificioID() {
        return edificioID;
    }

    public void setEdificioID(String edificioID) {
        this.edificioID = edificioID;
    }
}
