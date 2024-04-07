package com.banckend.backend.controles;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.servicios.IAutorizacionServicios;
import com.banckend.backend.servicios.modelos.datos.AccesoDatos;
import com.banckend.backend.servicios.modelos.datos.RespuestaDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class ControlesDeAutorizacion {

    @Autowired
    IAutorizacionServicios utorizacionServicios;

    @PostMapping("/register")
    private ResponseEntity<RespuestaDatos> registro(@RequestBody EntidadUsuario usuario) throws Exception {
        return new ResponseEntity<>(utorizacionServicios.registro(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<HashMap<String,String>> acceso(@RequestBody AccesoDatos login) throws Exception {
        HashMap<String,String> acceso = utorizacionServicios.acceso(login);
        if (acceso.containsKey("jwt")){
            return new ResponseEntity<>(acceso, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(acceso, HttpStatus.UNAUTHORIZED);
        }
    }
}
