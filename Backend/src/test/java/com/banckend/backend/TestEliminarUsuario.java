package com.banckend.backend;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.persistencia.repositorios.RepositorioUsuario;


@SpringBootTest
class TestEliminarUsuario {

    @Autowired
	private RepositorioUsuario repositorioUsuario;

    private EntidadUsuario usuario;

	@BeforeEach
	void setup(){
		usuario = EntidadUsuario.builder()
				.username("fernando")
				.email("fer123@gmail.com")
				.password("fer123")
				.build();
	}

    @DisplayName("Test para eliminar un usuario")
    @Test
    void testEliminarUsuario(){
        repositorioUsuario.save(usuario);

        // when 
        repositorioUsuario.deleteById(usuario.getId_usuario());
        Optional<EntidadUsuario> usuarioOptional = repositorioUsuario.findById(usuario.getId_usuario());

        // then
        assertThat(usuarioOptional).isEmpty();
    }

}
