package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.Usuario;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario,Long>{

    @Query("SELECT u FROM Usuario u WHERE u.email = :mail AND u.contrasenha =:password")
    List<Usuario> findUserByEmailAndPassword(String mail, String password);


}
