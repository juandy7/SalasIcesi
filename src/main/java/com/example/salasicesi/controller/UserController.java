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

import java.time.*;

import java.util.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioSalas repositorioSalas;

    @Autowired
    private RepositorioGestionSala repositorioGestionSala;

    //Login del usuario
    @PostMapping("salasIcesi/login")
    public ResponseEntity<?> login(@RequestBody LoginUsuarioDTO user) {
        var usuarios = repositorioUsuario.findUserByEmailAndPassword(user.getEmail(), user.getContrasenha());

        if (!usuarios.isEmpty()) {
            Usuario firstUser = usuarios.get(0);
            UsuarioDTO userReturn = new UsuarioDTO(firstUser.getId(), firstUser.getNombre(), firstUser.getEmail()
                    , firstUser.getContrasenha(), firstUser.getCodigo(), firstUser.getCategoria());
            return ResponseEntity.status(200).body(userReturn);

        }

        return ResponseEntity.status(400).body("Login inválido");
    }


    //Mostrar todos los usuarios
    @GetMapping("salasIcesi/administrador/userAll")
    public ResponseEntity<?> listUsuarios() {
            return ResponseEntity.status(200).body(
                    repositorioUsuario.findAll());
    }

    @GetMapping("salasIcesi/administrador/salasAll/{Autorizacion}")
    public ResponseEntity<?> listSalas() {
            return ResponseEntity.status(200).body(
                    repositorioSalas.findAll());

    }

    @GetMapping("salasIcesi/administrador/reservasAll/{Autorizacion}")
    public ResponseEntity<?> listReservas() {
            return ResponseEntity.status(200).body(
                    repositorioGestionSala.findAll());
    }


    @GetMapping("salasIcesi/informacion/{sala}")
    public ResponseEntity<?> listInfo(@PathVariable("sala") String sala) {
        try {
            var salaInfo = repositorioSalas.findClassByNum(sala).get(0);
            if (salaInfo != null) {
                return ResponseEntity.status(200).body(salaInfo);
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Sala not found  ");
        }
        return ResponseEntity.status(403).body("You do not have authorization");

    }

    @GetMapping("salasIcesi/{sala}/{dia}")
    public ResponseEntity<?> disponibilidadSala(@PathVariable("sala") String numSala, @PathVariable("dia") LocalDate dia) {
        try {
            var sala = repositorioSalas.findClassByNum(numSala).get(0);
            if (sala != null) {
                var disponibilidadSala = repositorioGestionSala.disponibilidad(sala, dia);
                ArrayList<LocalTime> horasReservadas = new ArrayList<>();
                for (int i = 0; i < disponibilidadSala.size(); i++) {
                    LocalTime hora = disponibilidadSala.get(i).getHora();
                    horasReservadas.add(hora);
                }
                return ResponseEntity.status(200).body(horasReservadas);
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Sala no encontrada");
        }
        return ResponseEntity.status(403).body("Sala disponible");

    }

    @PostMapping("salasIcesi/reservas/sala")
    public ResponseEntity<?> reservarSala(@RequestBody GestionSalaDTO gestionSalaDTO) {
        var sala = repositorioSalas.findById(gestionSalaDTO.getIdSala());
        var usuario = repositorioUsuario.findById(gestionSalaDTO.getIdUsuario());
        if (sala.isPresent() && usuario.isPresent() && sala.get().isEstado() == false) {
            List<GestionSala> salasReservadas = repositorioGestionSala.verificacionEstadoSala(gestionSalaDTO.getDia(), gestionSalaDTO.getHora());
            if (salasReservadas.isEmpty()) {
                GestionSala nuevaReserva = new GestionSala();
                nuevaReserva.setHora(gestionSalaDTO.getHora());
                nuevaReserva.setEstado(true);
                nuevaReserva.setToken(generateRandomToken());
                nuevaReserva.setDia(gestionSalaDTO.getDia());
                nuevaReserva.setSala(sala.get());
                nuevaReserva.setUsuario(usuario.get());
                repositorioGestionSala.save(nuevaReserva);
                return ResponseEntity.status(200).body("Sala reservada exitosamente");
            } else {
                return ResponseEntity.status(403).body("No se pudo realizar la solicitud. La sala ya está reservada a esa hora.");
            }
        } else {
            return ResponseEntity.status(403).body("No se pudo realizar la solicitud, probablemente la sala esta inhabilitada");
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


    @GetMapping("salasIcesi/misReservas/{id}")
    public ResponseEntity<?> misReservas(@PathVariable("id") long id) {
        var usuario = repositorioUsuario.findById(id);
        if (usuario.isPresent()) {
            var misReservas = repositorioGestionSala.verMisReservas(id);
            ArrayList<MisReservasDTO> misReservasDTO = new ArrayList<>();
            for (int i = 0; i < misReservas.size(); i++) {
                MisReservasDTO sala = new MisReservasDTO(misReservas.get(i).getId(),
                        misReservas.get(i).getHora(),
                        misReservas.get(i).getDia(),
                        misReservas.get(i).getSala().getNumSala(),
                        misReservas.get(i).getToken()
                );
                misReservasDTO.add(sala);
            }

            return ResponseEntity.status(200).body(misReservasDTO);
        }
        return ResponseEntity.status(403).body("No se encontraron salas ligadas a este usuario");
    }

    @GetMapping("Salasicesi/salones/{edificio}")
    //Recibo un header que es la letra del Edificio
    public ResponseEntity<?> listSalones(@PathVariable("edificio") String edificio) {
        //Tengo una variable "edificioXsalon" que en busca el edificioId(Nombre del edificio) del edificio que me mandaron por el header
        var edificioXsalon = repositorioSalas.findEdificio(edificio);
        //En caso de que ecuentre un edificio (String) entonces se hace un if
        if (!edificioXsalon.isEmpty()) {
            //Si hay algun edificio con ese nombre entonces toma el ID de ese edificio de la base de datos y como solo hay uno, toma el de la primera posicion

            var edificioEncontrado = edificioXsalon.get(0);

            //Una vez encontrado el ID del edificio se ve que salones estan asociados a este edificio
            var salones = repositorioSalas.findByEdificio(edificioEncontrado.getId());
            ;
            //PENDIENTE: Retornar en una lista(me imagino) de cada salon asociado al edificio
            return ResponseEntity.status(200).body(salones);
        } else {
            return ResponseEntity.status(404).body("Edificio no encontrado");
        }

    }

    @DeleteMapping("salasIcesi/misReservas/cancelar/{reservaId}")
    public ResponseEntity<?> cancelarReserva(@PathVariable("reservaId") long reservaID) {
        var salaEncontrada = repositorioGestionSala.findById(reservaID);
        if (!salaEncontrada.isEmpty()) {
            repositorioGestionSala.deleteById(reservaID);
            return ResponseEntity.status(200).body("Sala eliminada exitosamente");
        }
        return ResponseEntity.status(403).body("Ocurrio un problema al eliminar la sala");
    }

    @PostMapping("salasIcesi/administrador/reservas/sala")
    public ResponseEntity<?> reservarSalaAdministrador(@RequestBody GestionSalaDTO gestionSalaDTO) {
        var sala = repositorioSalas.findById(gestionSalaDTO.getIdSala());
        var usuario = repositorioUsuario.findUserByEmail(gestionSalaDTO.getCorreoUsuario());
        if (sala.isPresent() && !usuario.isEmpty()) {
            List<GestionSala> salasReservadas = repositorioGestionSala.verificacionEstadoSala(gestionSalaDTO.getDia(), gestionSalaDTO.getHora());
            if (salasReservadas.isEmpty()) {
                GestionSala nuevaReserva = new GestionSala();
                nuevaReserva.setHora(gestionSalaDTO.getHora());
                nuevaReserva.setEstado(true);
                nuevaReserva.setToken(generateRandomToken());
                nuevaReserva.setDia(gestionSalaDTO.getDia());
                nuevaReserva.setSala(sala.get());
                nuevaReserva.setUsuario(usuario.get(0));
                repositorioGestionSala.save(nuevaReserva);
                return ResponseEntity.status(200).body("Sala reservada exitosamente");
            } else {
                return ResponseEntity.status(403).body("No se pudo realizar la solicitud. La sala ya está reservada a esa hora.");
            }
        } else {
            return ResponseEntity.status(403).body("No se pudo realizar la solicitud");
        }
    }


    @PutMapping("salasIcesi/administrador/inhabilitarSala/{salaID}")
    public ResponseEntity<?> inhabilitarSala(@PathVariable("salaID") long salaID) {
        var sala = repositorioSalas.findById(salaID);
        if (sala.isPresent()) {
            sala.get().setEstado(true);
            repositorioSalas.save(sala.get());
            return ResponseEntity.status(200).body("Sala inhabilitada exitosamente");
        }
        return ResponseEntity.status(403).body("Ocurrio un problema en la inhabilitacion");

    }

    @PutMapping("salasIcesi/administrador/habilitar/{salaID}")
    public ResponseEntity<?> habilitarSala(@PathVariable("salaID") long salaID) {
        Optional<Sala> sala = repositorioSalas.findById(salaID);
        if (sala.isPresent()) {
            sala.get().setEstado(false);
            repositorioSalas.save(sala.get());
            return ResponseEntity.status(200).body("Sala habilitada exitosamente");
        }
        return ResponseEntity.status(403).body("Ocurrio un problema");
    }

    @DeleteMapping("salasIcesi/administrador/cancelar")
    public ResponseEntity<?> cancelarReserva(@RequestBody MisReservasDTO misReservasDTO) {
        var salaEncontrada = repositorioGestionSala.cancelarPorNumSala(misReservasDTO.getDia(),
                                                                       misReservasDTO.getHora(),
                                                                    misReservasDTO.getNumSala());
        if (!salaEncontrada.isEmpty()){
            repositorioGestionSala.deleteById(salaEncontrada.get(0).getId());
            return ResponseEntity.status(200).body("Sala eliminada exitosamente");
        }
        return ResponseEntity.status(403).body("Ocurrio un problema al eliminar la sala");
    }

    @GetMapping("salasIcesi/validarToken/{token}")
    public ResponseEntity<?> validarToken(@PathVariable String token){
        var sala = repositorioGestionSala.validarToken(token);
        if (!sala.isEmpty()) {
            return ResponseEntity.status(200).body("Sala desbloqueada");
        }
        return ResponseEntity.status(403).body("Codigo no disponible");
    }

}


