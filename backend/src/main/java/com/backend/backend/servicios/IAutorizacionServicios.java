package com.backend.backend.servicios;

import com.backend.backend.persistencia.entidades.EntidadUsuario;
import com.backend.backend.servicios.modelos.datos.AccesoDatos;
import com.backend.backend.servicios.modelos.datos.RespuestaDatos;

import java.util.HashMap;

public interface IAutorizacionServicios {

    public HashMap<String,String> acceso(AccesoDatos login) throws Exception;

    public RespuestaDatos registro(EntidadUsuario usuario) throws Exception;
}
