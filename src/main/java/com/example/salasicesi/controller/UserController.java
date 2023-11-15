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
            Categoria categoria = firstUser.verificarCredenciales(user.getEmail(), user.getContrasenha());

            RolDTO response = new RolDTO(categoria);
            if (categoria != null) {
                // Las credenciales son correctas, y puedes acceder a la categoría del usuario.
                return ResponseEntity.status(200).body(response);
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
    public ResponseEntity<?>disponibilidadSala(@RequestParam("Autorizacion") long aute){
        var sala = repositorioSalas.findById(aute);
        if (sala.isPresent()){
            if (sala.get().isEstado() == false ){
                return ResponseEntity.status(200).body("Sala disponible");
            }else
                return ResponseEntity.status(200).body("Sala ocupada");
        }
        else
            return ResponseEntity.status(403).body("Error al buscar disponibilidad de sala");
    }

    @GetMapping("salasIcesi/salones/{edificio}")
    //Recibo un header que es la letra del Edificio
    public ResponseEntity<?>listSalones(@PathVariable("edificio") String edificio){
        //Tengo una variable "edificioXsalon" que en busca el edificioId(Nombre del edificio) del edificio que me mandaron por el header
        var edificioXsalon = repositorioSalas.findEdificio(edificio);
        //En caso de que ecuentre un edificio (String) entonces se hace un if
        if (!edificioXsalon.isEmpty()){
            //Si hay algun edificio con ese nombre entonces toma el ID de ese edificio de la base de datos y como solo hay uno, toma el de la primera posicion
            var edificioEncontrado = edificioXsalon.get(0);

            //Una vez encontrado el ID del edificio se ve que salones estan asociados a este edificio
            var salones = repositorioSalas.findByEdificio(edificioEncontrado.getId());
           ;
            //PENDIENTE: Retornar en una lista(me imagino) de cada salon asociado al edificio
            return ResponseEntity.status(200).body(salones);
        }else {
            return ResponseEntity.status(404).body("Edificio no encontrado");
        }

    }

}
