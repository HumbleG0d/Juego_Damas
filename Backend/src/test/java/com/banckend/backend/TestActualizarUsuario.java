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
				.nombre_usuario("fernando")
				.correo_electronico("fer123@gmail.com")
				.contrasena("fer123")
				.build();
	}

    @DisplayName("Test para actualizar un usuario")
    @Test
    void testActualizarUsuario(){
        repositorioUsuario.save(usuario);

        // when(comportamiento que se va a probar)
        EntidadUsuario usuarioGuardado = repositorioUsuario.findById(usuario.getId_usuario()).get();
        usuarioGuardado.setNombre_usuario("Christian");
        usuarioGuardado.setCorreo_electronico("cris234@gmail.com");
        usuarioGuardado.setContrasena("cris234");
        EntidadUsuario usuarioActualizado = repositorioUsuario.save(usuarioGuardado);

        // then
        assertThat(usuarioActualizado.getNombre_usuario()).isEqualTo("Christian ");
        assertThat(usuarioActualizado.getCorreo_electronico()).isEqualTo("cris234@gmail.com");
    }
}
