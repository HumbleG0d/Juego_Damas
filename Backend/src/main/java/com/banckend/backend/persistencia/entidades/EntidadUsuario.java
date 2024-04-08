package com.banckend.backend.persistencia.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que JPA genere automaticamente el ID
    @Column(name = "id_usuario")
    private Long id_usuario;

    //@NotBlack
    //@size(min=3 , max=15)
    @Column(name = "username")
    private String username;

    //@Email
    //@NotBlack
    //Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(name = "email")
    private String email;

    //@NotBlack
    //@Size(min=8, max=16)
    //Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")
    @Column(name = "password")
    private String password;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

