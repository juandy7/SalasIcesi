package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSalas extends CrudRepository<Sala,Long> {
    @Query("SELECT s FROM Sala s WHERE s.numSala = :buscarNumSala")
    List<Sala> getSalabyNum(String buscarNumSala);


}