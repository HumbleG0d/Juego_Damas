package com.banckend.backend.servicios.modelos.datos;

public class RespuestaDatos {

    private int numero_errores;

    private String mensaje;

    public int getNumero_errores() { return numero_errores;}

    public void setNumero_errores( int numero_errores){ this.numero_errores = numero_errores;}

    public String getMensaje(){ return mensaje;}

    public void setMensaje( String mensaje){ this.mensaje = mensaje;}
}
