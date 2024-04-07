package com.banckend.backend.servicios;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.servicios.modelos.datos.AccesoDatos;
import com.banckend.backend.servicios.modelos.datos.RespuestaDatos;

import java.util.HashMap;

public interface IAutorizacionServicios {

    public HashMap<String, String> acceso(AccesoDatos login) throws Exception;

    public RespuestaDatos registro(EntidadUsuario usuario) throws Exception;
}
