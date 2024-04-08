package com.banckend.backend.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder // 
@AllArgsConstructor //
@NoArgsConstructor //
@Entity
@Table(name = "DatosDeUsuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombre_usuario;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correo_electronico;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

