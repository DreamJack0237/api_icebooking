package com.example.icebooking.config;

import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.services.UtilisateurService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class JwtService {
    private final String ENCRYPTION_KEY="f239aa2de8851ab62ecb1c731773791f66f4b3b9cc5695459ac91fc2effb8bb3";
    private UtilisateurService utilisateurService;


    public Map<String,String> generate(String username){

      Utilisateur utilisateur =  this.utilisateurService.loadUserByUsername(username);

        return this.generateJwt(utilisateur);
    }

    private Map<String, String> generateJwt(Utilisateur utilisateur) {
        final long curenTime =System.currentTimeMillis();
        final long expireCurenTime= curenTime + 30 * 60 * 1000;

        Map<String, Object> claims = Map.of(
                "nom", utilisateur.getNom(),
                Claims.EXPIRATION, new Date(expireCurenTime),
                Claims.SUBJECT,utilisateur.getEmail()

        );

        String bearer = Jwts.builder()
                .setIssuedAt(new Date(curenTime))
                .setExpiration(new Date(expireCurenTime))
                .setSubject(utilisateur.getEmail())
                .setClaims(claims)
                .signWith(getkey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of("bearer",bearer );
        
    }

    private Key getkey() {
        final byte[] decoder = Decoders.BASE64.decode(ENCRYPTION_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }

    public String ExtractUsername(String token) {
        return   this.getClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate =this.getClaim(token, Claims::getExpiration);
        System.out.println(expirationDate);
//        log.info(expirationDate);
        return expirationDate.before(new Date());
    }

//    private Date getExpirationDateFromToken(String token)
//     {
//        return this.getClaim(token, Claims::getExpiration);
//    }

    private <T> T getClaim(String token, Function<Claims, T> function) {
        Claims claims= getAllClaim(token);
        return function.apply(claims);
    }

    private Claims getAllClaim(String token) {
        return Jwts.parser()
                .setSigningKey(this.getkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
