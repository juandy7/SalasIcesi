package com.example.salasicesi.controller;


import com.example.salasicesi.model.Repositorio.RepositorioUsuario;
import com.example.salasicesi.model.Repositorio.RepositorioSalas;
import com.example.salasicesi.model.dto.*;
import com.example.salasicesi.model.entity.Categoria;
import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioSalas repositorioSalas;

    //Loguin del usuario
    @PostMapping("salasIcesi/login")
    public ResponseEntity<?> login(@RequestBody LoginUsuarioDTO user) {
        var usuarios = repositorioUsuario.findUserByEmailAndPassword(user.getEmail(), user.getContrasenha());

        if (!usuarios.isEmpty()) {
            Usuario firstUser = usuarios.get(0);
            UsuarioDTO userReturn = new UsuarioDTO(firstUser.getNombre(), firstUser.getEmail()
                    ,firstUser.getContrasenha(),firstUser.getCodigo(),firstUser.getCategoria());
                return ResponseEntity.status(200).body(userReturn);

        }

        return ResponseEntity.status(400).body("Login inválido");
    }


    //Mostrar todos los usuarios
    @GetMapping("salasIcesi/usersAll")
    public ResponseEntity<?> listUsuarios(@RequestParam("Autorizacion") long aute){
        var user =  repositorioUsuario.findById(aute);
        if (user.isPresent()){
            return ResponseEntity.status(200).body(
                    repositorioUsuario.findAll());
        }else {
            return ResponseEntity.status(403).body("No tiene acceso permitido");
        }
    }

    @GetMapping("salasIcesi/disponibilidad/{sala}{dia}")
    public ResponseEntity<?>disponibilidadSala(@RequestParam("sala") long aute,
                                               @RequestParam("dia") LocalDate dia){
        var sala = repositorioSalas.findById(aute);
        if (sala.isPresent()){
            var disponibilidadSala = repositorioSalas.findDisponibilidadSala(dia);
            if (disponibilidadSala.get(){
                return ResponseEntity.status(200).body("Sala disponible");
            }else
                return ResponseEntity.status(405).body("Sala ocupada");
        }
        else
            return ResponseEntity.status(403).body("Error al buscar disponibilidad de sala");
    }


}
