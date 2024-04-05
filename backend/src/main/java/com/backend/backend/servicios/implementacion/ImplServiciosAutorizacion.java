package com.backend.backend.servicios.implementacion;

import com.backend.backend.persistencia.entidades.EntidadUsuario;
import com.backend.backend.persistencia.repositorios.RepositorioUsuario;
import com.backend.backend.servicios.IAutorizacionServicios;
import com.backend.backend.servicios.IUtilidadServicioJWT;
import com.backend.backend.servicios.modelos.datos.AccesoDatos;
import com.backend.backend.servicios.modelos.datos.RespuestaDatos;
import com.backend.backend.servicios.modelos.validacion.ValidacionUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ImplServiciosAutorizacion implements IAutorizacionServicios {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private IUtilidadServicioJWT UtilidadServicioJWT;

    @Autowired
    private ValidacionUsuario validacionUsuario;


    @Override
    public HashMap<String, String> acceso(AccesoDatos login) throws Exception {
        try {
            HashMap<String,String> jwt = new HashMap<>();
            Optional<EntidadUsuario> usuario = repositorioUsuario.findByEmail(login.getCorreo_electronico());

            if(usuario.isEmpty()){
                jwt.put("error","Usuario no registrado");
                return jwt;
            }

            if(verificarContraseña(login.getContraseña(),usuario.get().getContraseña())){
                jwt.put("jwt",UtilidadServicioJWT.generateJWT(usuario.get().getId_usuario()));
            }
            else{
                jwt.put("error","Autenticacion fallida");
            }

            return jwt;
        }catch (Exception e){
            throw new Exception(e.toString());
        }
    }

    @Override
    public RespuestaDatos registro(EntidadUsuario usuario) throws Exception {
        try {
            RespuestaDatos respuesta = validacionUsuario.validacion(usuario);

            if(respuesta.getNumero_errores() > 0){
                return respuesta;
            }

            List<EntidadUsuario> getAllUsers = repositorioUsuario.findAll();

            for(EntidadUsuario users : getAllUsers){
                if(users != null){
                    respuesta.setNumero_errores(1);
                    respuesta.setMensaje("El usuario existe");
                    return respuesta;
                }
            }

            BCryptPasswordEncoder codificar = new BCryptPasswordEncoder(12);
            usuario.setContraseña(codificar.encode(usuario.getContraseña()));
            repositorioUsuario.save(usuario);
            respuesta.setMensaje("Usuario creado satisfactoriamente");

            return respuesta;
        }catch (Exception e){
            throw new Exception(e.toString());
        }
    }

    private boolean verificarContraseña(String contraseñaEntrante, String contraseñaAlmacenada){
        BCryptPasswordEncoder codificar = new BCryptPasswordEncoder();
        return codificar.matches(contraseñaEntrante,contraseñaAlmacenada);
    }
}
