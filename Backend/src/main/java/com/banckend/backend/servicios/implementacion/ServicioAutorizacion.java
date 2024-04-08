package com.banckend.backend.servicios.implementacion;

import com.banckend.backend.persistencia.entidades.EntidadUsuario;
import com.banckend.backend.persistencia.repositorios.RepositorioUsuario;
import com.banckend.backend.servicios.IAutorizacionServicios;
import com.banckend.backend.servicios.IUtilidadServicioJWT;
import com.banckend.backend.servicios.modelos.datos.AccesoDatos;
import com.banckend.backend.servicios.modelos.datos.RespuestaDatos;
import com.banckend.backend.servicios.modelos.validacion.ValidacionUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioAutorizacion implements IAutorizacionServicios {

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
            Optional<EntidadUsuario> usuario = repositorioUsuario.findByUsername(login.getNombre_usuario());

            if(usuario.isEmpty()){
                jwt.put("error","Usuario no registrado");
                return jwt;
            }

            if(verificarContraseña(login.getPassword(),usuario.get().getPassword())){
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

            Optional<EntidadUsuario> getAllUsers = repositorioUsuario.findByUsername(usuario.getNombre_usuario());
            
            if(getAllUsers.isPresent()){//Verificamos si el usuario a registrar ya esta registrado
                respuesta.setNumero_errores(1);
                respuesta.setMensaje("El usuario ya existe");
                return respuesta;

            }

            BCryptPasswordEncoder codificar = new BCryptPasswordEncoder(12);
            usuario.setPassword(codificar.encode(usuario.getPassword()));
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
