package com.backend.backend.servicios;

import com.backend.backend.persistencia.entidades.EntidadUsuario;

import java.util.List;

public interface IServiciosUsuarios {

    public List<EntidadUsuario> findAllUser();
}
