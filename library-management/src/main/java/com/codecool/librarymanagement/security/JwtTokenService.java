package com.codecool.librarymanagement.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtTokenService {

    @Value("${security.jwt.token.secret-key:secretKey}")
    private String secretKey = "secretKey";

    @Value("${security.jwt.token.expire-length:3600000}")
    private final long validityInMilliSeconds = 3600000; // 1hour

    private final String rolesFieldName = "roles";

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, List<String> roles){

        Claims claims = Jwts.claims().setSubject(username);
        claims.put(rolesFieldName, roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliSeconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.ES256, secretKey)
                .compact();
    }

}
