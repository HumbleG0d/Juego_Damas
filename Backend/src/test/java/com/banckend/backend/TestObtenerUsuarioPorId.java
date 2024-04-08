package com.banckend.backend;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;


import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.persistencia.repositorios.RepositorioUsuario;


@SpringBootTest
class TestObtenerUsuarioPorId {

    @Autowired
	private RepositorioUsuario repositorioUsuario;

    private EntidadUsuario usuario;

    @BeforeEach
	void setup(){
		usuario = EntidadUsuario.builder()
				.username("marco")
				.email("marco123@gmail.com")
				.password("marco123")
				.build();
	}

    @DisplayName("Test para obtener un usuario por ID")
    @Test
    void testObtenerUsuarioPorId(){
        repositorioUsuario.save(usuario);

        // when
        EntidadUsuario usuarioBD = repositorioUsuario.findById(usuario.getId_usuario()).get();

        // then
        assertThat(usuarioBD).isNotNull();
    }



}
