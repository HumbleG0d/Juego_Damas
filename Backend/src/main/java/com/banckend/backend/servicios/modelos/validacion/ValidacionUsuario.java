package com.banckend.backend.servicios.modelos.validacion;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.servicios.modelos.datos.RespuestaDatos;

public class ValidacionUsuario {

    public RespuestaDatos validacion(EntidadUsuario usuario){
        RespuestaDatos respuesta = new RespuestaDatos();

        respuesta.setNumero_errores(0);

        if(usuario.getNombre_usuario() == null || usuario.getNombre_usuario().length() < 3 || usuario.getNombre_usuario().length() > 15){
            respuesta.setNumero_errores(respuesta.getNumero_errores() + 1);
            respuesta.setMensaje("El campo nombre_usuario no puede ser nulo y debe tener entre 3 y 15 caracteres.");
        }

        if(usuario.getCorreo_electronico() == null || !usuario.getCorreo_electronico().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            respuesta.setNumero_errores(respuesta.getNumero_errores() + 1);
            respuesta.setMensaje("El campo de correo electronico no es valido");
        }

        if(usuario.getContrasena() == null || !usuario.getContrasena().matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")){
            respuesta.setNumero_errores(respuesta.getNumero_errores() + 1);
            respuesta.setMensaje("La contraseña debe tener entre 8y 16 caracteres, al menos un numero, una minuscula y una mayuscula");
        }

        return respuesta;
    }
}
