package com.backend.backend.servicios;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

public interface IUtilidadServicioJWT {

    public String generateJWT(Long id_usuario) throws IOException, NoSuchAlgorithmException, InvalidKeyException, JOSEException, InvalidKeySpecException;
    public JWTClaimsSet parseJWT(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeyException, ParseException, JOSEException, InvalidKeySpecException;
}
