package com.example.task01.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Sanjarbek Allayev, ср 9:08. 09.03.2022
 */
@Component
public class JwtProvider {
    String secret ="MaxfiySo'z";
    long expireTime=1000*86400;


    public String generateToken(String userName){
        return  Jwts.builder().setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expireTime))
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

//    jwt ni expire
public boolean expireToken(String token){
    try{
        Date expiration = Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.after(new Date());
    }catch (Exception e){
        return false;
    }

}

// jwt ni validatsiya qilish

    public boolean validateToken(String token){

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (SignatureException e){
            return false;
        }
        catch (Exception e){
            return false;
        }
    }


    // jwtdan tizim ucun kim kirdi?
    public String getUsernameFromToken(String token){
        String subject = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        return subject;
    }

}
