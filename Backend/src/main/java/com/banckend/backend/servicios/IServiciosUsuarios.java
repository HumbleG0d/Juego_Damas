package com.banckend.backend.servicios;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;

import java.util.List;

public interface IServiciosUsuarios {

    public List<EntidadUsuario> findAllUser();
}
