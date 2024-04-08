package com.banckend.backend.seguridad;


import com.banckend.backend.servicios.IUtilidadServicioJWT;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad {

    @Autowired
    private IUtilidadServicioJWT iutilidadServicioJWT;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//Clase para el comportameinto de acceso a los endpoint
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest // Configuracion de que direccion van a estar protegidas
                        .requestMatchers("/auth/**").permitAll() // Se puede acceder sin ningun tipo de autorizacion a /auth/**
                        .anyRequest().authenticated())// Cualquier otro direccion tiene que estar autenticado
                .sessionManagement(sessionManager -> sessionManager // Para configurar el comportamiento de las sesiones
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))// Para la creacion y gurdado se sesiones
                .addFilterBefore(new FiltrosDeAutorizacionJWT(iutilidadServicioJWT), UsernamePasswordAuthenticationFilter.class)//Se agrego los filtros de autorizacion
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint((request, response, authException) ->
                {response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No autorizado");}))//Para el tipo de autenticacion no autorizada
                .build();// retorna el SecurityFilterChain
    }

    @Bean
    public PasswordEncoder passwordEncoder(){//Clase para encriptar la contraseña
        return new BCryptPasswordEncoder();//retorna el algoritmo de encriptacion BCryptPasswordEncoder
    }
}
