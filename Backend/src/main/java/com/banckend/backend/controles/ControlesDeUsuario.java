package com.banckend.backend.controles;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.servicios.IServiciosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ControlesDeUsuario {

    @Autowired
    IServiciosUsuarios servicios;

    @GetMapping("/allusers")
    private ResponseEntity<List<EntidadUsuario>> getAllUsers(){ //Devuelve la lista de usuarios del sistema
        return new ResponseEntity<>(servicios.findAllUser(), HttpStatus.OK);
    }
}
