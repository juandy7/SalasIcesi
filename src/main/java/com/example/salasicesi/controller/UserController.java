package com.example.salasicesi.controller;


import com.example.salasicesi.model.Repositorio.RepositorioUsuario;
import com.example.salasicesi.model.dto.UsuarioDTO;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    private RepositorioUsuario repositorio;


/*
    @GetMapping("user/all")
    public ResponseEntity<?>getAll() {
        var users = repositorio.findAll();
        var output = new ArrayList<UsuarioDTO>();
        users.forEach(usuario ->
                output.add(
                        new UsuarioDTO(usuario.getNombre(), usuario.getEmail(), usuario.getContrasenha(), usuario.getCodigo())
                );
    });
        return ResponseEntity.status(200).body(output);
    }

    @PostMapping("user/create")

    public ResponseEntity<?> create(@RequestBody UsuarioDTO user){

        //Mapping
        //DTO -> Entity
        Usuario userEntity = create(0, user.getNombre(),user.getEmail());
        //Guardamos en la base de datos
        repositorio.save(userEntity);

        return ResponseEntity.status(200).body(user);
    }



 */
}
