package com.backend.backend.servicios.implementacion;

import com.backend.backend.persistencia.entidades.EntidadUsuario;
import com.backend.backend.persistencia.repositorios.RepositorioUsuario;
import com.backend.backend.servicios.IServiciosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosUsuarios implements IServiciosUsuarios {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Override
    public List<EntidadUsuario> findAllUser(){
        return repositorioUsuario.findAll();
    }
}
