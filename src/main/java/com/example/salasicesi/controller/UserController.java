package com.example.salasicesi.controller;


import com.example.salasicesi.model.Repositorio.RepositorioGestionSala;
import com.example.salasicesi.model.Repositorio.RepositorioUsuario;
import com.example.salasicesi.model.Repositorio.RepositorioSalas;
import com.example.salasicesi.model.dto.*;
import com.example.salasicesi.model.entity.Categoria;
import com.example.salasicesi.model.entity.GestionSala;
import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioSalas repositorioSalas;

    @Autowired
    private RepositorioGestionSala repositorioGestionSala;

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



    @PostMapping("salasIcesi/reservas/sala")
    public ResponseEntity<?> reservarSala(@RequestBody GestionSalaDTO gestionSalaDTO) {
        var sala = repositorioSalas.findById(gestionSalaDTO.getIdSala());
        var usuario = repositorioUsuario.findById(gestionSalaDTO.getIdUsuario());
        if (sala.isPresent() && usuario.isPresent()) {
            List<GestionSala> salasReservadas = repositorioGestionSala.verificacionEstadoSala(gestionSalaDTO.getDia(),gestionSalaDTO.getHora());
            if (salasReservadas.isEmpty()) {
                GestionSala nuevaReserva = new GestionSala();
                nuevaReserva.setHora(gestionSalaDTO.getHora());
                nuevaReserva.setEstado(true);
                nuevaReserva.setToken(generateRandomToken());
                nuevaReserva.setDia(gestionSalaDTO.getDia());
                nuevaReserva.setSala(sala.get());
                nuevaReserva.setUsuario(usuario.get());
                repositorioGestionSala.save(nuevaReserva);
                nuevaReserva.setId(UUID.randomUUID().toString());
                return ResponseEntity.status(200).body(nuevaReserva);
            } else {
                return ResponseEntity.status(403).body("No se pudo realizar la solicitud. La sala ya está reservada a esa hora.");
            }
        } else {
            return ResponseEntity.status(403).body("No se pudo realizar la solicitud");
        }
    }

    private String generateRandomToken() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }




}
