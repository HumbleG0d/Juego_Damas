package com.banckend.backend.persistencia.repositorios;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepositorioUsuario extends JpaRepository<EntidadUsuario, Long> {

    @Query(value = "SELECT * FROM users WHERE username= :username", nativeQuery = true) // Se especifica el @Query con
                                                                                        // que se hara la busqueda de
                                                                                        // correo_electronico
    Optional<EntidadUsuario> findByUsername(String username);// Busqueda de correo electronico

}
