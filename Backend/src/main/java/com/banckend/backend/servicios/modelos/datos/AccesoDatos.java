package com.banckend.backend.servicios.modelos.datos;

public class AccesoDatos {

    private String username;

    private String password;

    public String getNombre_usuario(){ return username;}

    public void setNombre_usario(String username){ this.username = username;}

    public String getPassword(){ return password;}

    public void setPassword(String password){ this.password = password;}
}
