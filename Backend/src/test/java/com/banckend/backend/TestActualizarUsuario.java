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
class TestActualizarUsuario {

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

    @DisplayName("Test para actualizar un usuario")
    @Test
    void testActualizarUsuario(){
        repositorioUsuario.save(usuario);

        // when(comportamiento que se va a probar)
        EntidadUsuario usuarioGuardado = repositorioUsuario.findById(usuario.getId_usuario()).get();
        usuarioGuardado.setUsername("Christian");
        usuarioGuardado.setEmail("cris234@gmail.com");
        usuarioGuardado.setPassword("cris234");
        EntidadUsuario usuarioActualizado = repositorioUsuario.save(usuarioGuardado);

        // then
        assertThat(usuarioActualizado.getUsername()).isEqualTo("Christian ");
        assertThat(usuarioActualizado.getEmail()).isEqualTo("cris234@gmail.com");
    }
}
