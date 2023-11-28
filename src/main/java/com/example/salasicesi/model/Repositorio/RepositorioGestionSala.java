package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.GestionSala;
import com.example.salasicesi.model.entity.Sala;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface RepositorioGestionSala extends CrudRepository<GestionSala,Long> {

    @Query("SELECT s FROM GestionSala s WHERE s.dia =:dia AND s.hora =:hora")
    List<GestionSala> verificacionEstadoSala(LocalDate dia, LocalTime hora);

    @Query("SELECT s FROM GestionSala s WHERE s.sala =:sala AND s.dia =:dia")
    List<GestionSala> disponibilidad(Sala sala, LocalDate dia);

    @Query("SELECT u FROM GestionSala u WHERE u.usuario.id=:id")
    List<GestionSala> verMisReservas(long id);

    @Query("SELECT s FROM GestionSala s WHERE s.sala.id =: sala")
    List<GestionSala> buscarPorIDsala(long sala);
}
