package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.Edificio;
import com.example.salasicesi.model.entity.Sala;
import com.example.salasicesi.model.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSalas extends CrudRepository<Sala,Long> {

    @Query("SELECT s FROM SalasPorEdificio s WHERE s.edificio=:edificio")
    List<Sala> findByEdificio(String edificio);

    @Query("SELECT e FROM Edificio e WHERE e.edificioID=:edificio")
    List<Edificio> findEdificio(String edificio);
}
