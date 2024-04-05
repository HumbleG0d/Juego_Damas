package com.banckend.backend.servicios.implementacion;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.persistencia.repositorios.RepositorioUsuario;
import com.banckend.backend.servicios.IServiciosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario implements IServiciosUsuarios {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Override
    public List<EntidadUsuario> findAllUser(){
        return repositorioUsuario.findAll();
    }
}
