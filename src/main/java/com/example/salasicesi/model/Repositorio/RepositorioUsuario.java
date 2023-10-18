package com.example.salasicesi.model.Repositorio;

import com.example.salasicesi.model.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioUsuario extends CrudRepository<Usuario,Long>{

    @Query("SELECT u FROM Usuario u WHERE u.email = :buscarEmail")
    List<Usuario> getUsuarioByEmail(String buscarEmail);

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.contrasenha =: password")
    List<Usuario> findUserByEmailAndPassword(String email, String contrasenha);
}
