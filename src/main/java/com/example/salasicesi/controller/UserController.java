package com.example.salasicesi.controller;


import com.example.salasicesi.model.Repositorio.RepositorioUsuario;
import com.example.salasicesi.model.Repositorio.RepositorioSalas;
import com.example.salasicesi.model.dto.*;
import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    private RepositorioUsuario repositorio;
    @Autowired
    private RepositorioSalas repositorioSalas;

    @PostMapping("salasIcesi/login")
    public ResponseEntity<?> createUser(@RequestBody LoginUsuarioDTO user){
        var usuarios = repositorio.findUserByEmailAndPassword(user.getEmail(), user.getContrasenha());
        if (usuarios.size()>0){
            user.setId((usuarios.get(0).getId())); //Esta en string pasarlo a entero
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(400).body("Login invalido");
        }
    }

    @GetMapping("salasIcesi/usersAll")
    public ResponseEntity<?> listUsuarios(@RequestParam("Autorizacion") long aute){
        var user = repositorio.findById(aute);
        if (user.isPresent()){
            return ResponseEntity.status(200).body(
                    repositorio.findAll()
            );
        }else {
            return ResponseEntity.status(403).body("No tiene acceso permitido");
        }
    }
}
