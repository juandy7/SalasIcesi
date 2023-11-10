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
        var usuario = repositorioUsuario.findUserByEmailAndPassword(user.getEmail(), user.getContrasenha());

        if (!usuario.isEmpty()) {
            Usuario firstUser = usuario.get(0);
            Categoria categoria = firstUser.verificarCredenciales(user.getEmail(), user.getContrasenha());

            if (categoria != null) {
                // Las credenciales son correctas, y puedes acceder a la categoría del usuario.
                return ResponseEntity.status(200).body(categoria);
            }
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

    @GetMapping("salasIcesi/disponibilidad")
    public ResponseEntity<?> disponibilidadSala(@RequestParam String numSala) {
        var salas = repositorioSalas.getSalabyNum(numSala);
        if (salas.size() > 0) {
            boolean estadoSala = salas.get(0).isEstado();
            String disponibilidad = estadoSala ? "Disponible" : "No Disponible";
            return ResponseEntity.status(200).body(disponibilidad);
        } else {
            return ResponseEntity.status(404).body("Sala no encontrada");
        }
    }





}
