package com.banckend.backend.configuracion;

import com.banckend.backend.servicios.modelos.validacion.ValidacionUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionDeValidacion {

    @Bean
    public ValidacionUsuario validacionUsuario(){
        return new ValidacionUsuario();
    }
}
