package com.banckend.backend.seguridad;

import com.banckend.backend.servicios.IUtilidadServicioJWT;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Collections;

@Service
public class FiltrosDeAutorizacionJWT extends OncePerRequestFilter {

    @Autowired
    IUtilidadServicioJWT iUtilidadServicioJWT;

    public FiltrosDeAutorizacionJWT(IUtilidadServicioJWT iutilidadServicioJWT) {
        this.iUtilidadServicioJWT = iutilidadServicioJWT;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization"); //Se obtiene el JWT a traver del Header
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response); // Hace que se invoque el siguiente filtro de la cadena
            return;
        }

        String token = header.substring(7); // extraemos en bearer del token de los 7 primeros caracteres del header

        try {
            JWTClaimsSet claimsSet = iUtilidadServicioJWT.parseJWT(token);// Se obtiene los claims que son piesas de informacion del token
            UsernamePasswordAuthenticationToken autenticacionToken=
                    new UsernamePasswordAuthenticationToken(claimsSet.getSubject(), null, Collections.emptyList());

            SecurityContextHolder.getContext().setAuthentication(autenticacionToken);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

        filterChain.doFilter(request,response);
    }
}
