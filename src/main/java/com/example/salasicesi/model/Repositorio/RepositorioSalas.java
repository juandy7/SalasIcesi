package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositorioSalas extends CrudRepository<Sala,Long> {



    @Query("SELECT u FROM Sala u WHERE u.numSala =:num_sala")
    List<Sala> findClassByNum(String num_sala);


}
