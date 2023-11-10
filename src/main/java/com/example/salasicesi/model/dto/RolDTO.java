package com.example.salasicesi.model.dto;

import com.example.salasicesi.model.entity.Categoria;

public class RolDTO {

    Categoria rol;
    public RolDTO(Categoria rol) {
        this.rol = rol;
    }

    public Categoria getRol() {
        return rol;
    }

    public void setRol(Categoria rol) {
        this.rol = rol;
    }
}
