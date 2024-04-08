package com.banckend.backend.servicios.implementacion;

import com.banckend.backend.servicios.IUtilidadServicioJWT;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;

@Service
public class UtilidadServicioJWT implements IUtilidadServicioJWT {

    @Value("classpath:jwtLlaves/private_key.pem")
    private Resource privateKeyResource;

    @Value("Classpath.jwtLlaves/public_key.pem")
    private Resource publicKeyResource;

    @Override
    public String generateJWT(Long id_usuario) throws IOException, NoSuchAlgorithmException, JOSEException, InvalidKeySpecException {
        PrivateKey privateKey = cargarLlavePrivada(privateKeyResource);

        JWSSigner signer = new RSASSASigner(privateKey);

        Date now = new Date();

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(id_usuario.toString())
                .issueTime(now)
                .expirationTime(new Date(now.getTime() + 14400000))
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256),claimsSet);
        signedJWT.sign(signer);

        return signedJWT.serialize();
    }

    @Override
    public JWTClaimsSet parseJWT(String jwt) throws IOException, NoSuchAlgorithmException, ParseException, JOSEException, InvalidKeySpecException {
        PublicKey publicKey = cargarLlavePublica(publicKeyResource);
        SignedJWT signedJWT = SignedJWT.parse(jwt);
        JWSVerifier verificar = new RSASSAVerifier((RSAPublicKey)publicKey);

        if(!signedJWT.verify(verificar)){
            throw new JOSEException("Firma invalida");
        }

        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

        if(claimsSet.getExpirationTime().before(new Date())){
            throw new JOSEException("Firma expirada");
        }

        return claimsSet;
    }

    private PrivateKey cargarLlavePrivada(Resource resource) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(resource.getURI()));
        String privateKeyPem = new String(keyBytes, StandardCharsets.UTF_8)
                .replace("-----BEGIN PRIVATE KEY-----","")
                .replace("-----END PRIVATE KEY-----","")
                .replaceAll("\\s","");

        byte[] descodificar = Base64.getDecoder().decode(privateKeyPem);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(descodificar));
    }

    private PublicKey cargarLlavePublica(Resource resource) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(resource.getURI()));
        String publicKeyPem = new String(keyBytes,StandardCharsets.UTF_8)
                .replace("-----BEGIN PUBLIC KEY-----","")
                .replace("-----END PUBLIC KEY-----","")
                .replaceAll("\\s","");

        byte[] descodificar = Base64.getDecoder().decode(publicKeyPem);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePublic(new PKCS8EncodedKeySpec(descodificar));
    }
}