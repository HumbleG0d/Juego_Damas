package com.banckend.backend;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.persistencia.repositorios.RepositorioUsuario;


@SpringBootTest
class TestListarUsuarios {

    @Autowired
	private RepositorioUsuario repositorioUsuario;

	private EntidadUsuario usuario;

    @BeforeEach
	void setup(){
		usuario = EntidadUsuario.builder()
				.nombre_usuario("Gabriel")
				.correo_electronico("gabriel123@gmail.com")
				.contrasena("gabriel123")
				.build();
	}

	@DisplayName("Test para listar a los usuarios")
    @Test
	void testListarUsuarios(){
		//given 
		EntidadUsuario usuario1 = EntidadUsuario.builder()
						.nombre_usuario("Omar")
						.correo_electronico("omar123@gmail.com")
						.contrasena("omar123")
						.build();
		repositorioUsuario.save(usuario1);
		repositorioUsuario.save(usuario);
		
		//when 
		List<EntidadUsuario> listaUsuarios = repositorioUsuario.findAll();

		//then
		assertThat(listaUsuarios).isNotNull();
		assertThat(listaUsuarios.size()).isEqualTo(5);	

	}
}
