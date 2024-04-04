package com.backend.backend.persistencia.repositorios;

import com.backend.backend.persistencia.entidades.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepositorioUsuario extends JpaRepository<EntidadUsuario,Long> {

    @Query(value ="SELECT * FROM DatosDeUsuario WHERE correo_electronico = :correo_electronico", nativeQuery = true)
    Optional<EntidadUsuario> findByEmail(String email);
}
