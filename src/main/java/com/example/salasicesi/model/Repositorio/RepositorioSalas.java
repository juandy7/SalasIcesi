package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import com.example.salasicesi.model.entity.Edificio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositorioSalas extends CrudRepository<Sala,Long> {


    @Query("SELECT s FROM GestionSala s WHERE s.dia=:dia")
    List<Sala> findDisponibilidadSala(LocalDate dia);

    //En esta QUERY se recibe el id de edificio y en la tabla de SalasPorEdificio se busca los salones asociados a este
    @Query("SELECT s FROM SalasPorEdificio sp INNER JOIN sp.sala s WHERE sp.edificio.id =:id")
    public List<Sala> findByEdificio(long id);
    //En esta QUERY se busca el edificio por su edificioID(ej:A,B,C,D,E)
    @Query("SELECT e FROM Edificio e WHERE e.edificioID=:edificio")
    List<Edificio> findEdificio(String edificio);

    @Query("SELECT u FROM Sala u WHERE u.numSala =:num_sala")
    List<Sala> findClassByNum(String num_sala);

}
