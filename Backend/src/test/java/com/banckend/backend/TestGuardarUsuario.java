package com.banckend.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.persistencia.repositorios.RepositorioUsuario;


@SpringBootTest
class TestGuardarUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@BeforeEach
	void setup(){
		System.out.println("Hola Mundo");
	}

	@DisplayName("Test para guardar a los usuarios")
	@Test
	void testGuardarUsuario(){
		
		//given - dado o condicion previa o configuracion
		EntidadUsuario usuario1 = EntidadUsuario.builder()
						.username("Carlos")
						.email("carlos123@gmail.com")
						.password("carlos123")
						.build();
		//when - accion o el comportamiento que vamos a probar 
		EntidadUsuario usuarioGuardado = repositorioUsuario.save(usuario1);
		
		//then - verificar la salida
		assertThat(usuarioGuardado).isNotNull();
		assertThat(usuarioGuardado.getId_usuario()).isGreaterThan(0);

	}
 
}
