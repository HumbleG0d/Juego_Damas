package com.banckend.backend.servicios.modelos.validacion;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.servicios.modelos.datos.RespuestaDatos;

public class ValidacionUsuario {

    public RespuestaDatos validacion(EntidadUsuario usuario){
        RespuestaDatos respuesta = new RespuestaDatos();

        respuesta.setNumero_errores(0);

        if(usuario.getUsername() == null || usuario.getUsername().length() < 3 || usuario.getUsername().length() > 15){
            respuesta.setNumero_errores(respuesta.getNumero_errores() + 1);
            respuesta.setMensaje("El campo nombre_usuario no puede ser nulo y debe tener entre 3 y 15 caracteres.");
        }

        if(usuario.getEmail() == null || !usuario.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            respuesta.setNumero_errores(respuesta.getNumero_errores() + 1);
            respuesta.setMensaje("El campo de correo electronico no es valido");
        }

        if(usuario.getPassword() == null || !usuario.getPassword().matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")){
            respuesta.setNumero_errores(respuesta.getNumero_errores() + 1);
            respuesta.setMensaje("La contraseña debe tener entre 8y 16 caracteres, al menos un numero, una minuscula y una mayuscula");
        }

        return respuesta;
    }
}
