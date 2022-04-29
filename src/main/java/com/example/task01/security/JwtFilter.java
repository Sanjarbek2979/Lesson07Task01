package com.example.task01.security;

import com.example.task01.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sanjarbek Allayev, ср 9:08. 09.03.2022
 */
//  har bir request dan oldin kim kiryapti
    @Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    AuthService authService;
    @Autowired
    JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (jwtProvider.validateToken(token)){
            if (jwtProvider.expireToken(token)){
                String usernameFromToken = jwtProvider.getUsernameFromToken(token);

                UserDetails userDetails = authService.loadUserByUsername(usernameFromToken);

                UsernamePasswordAuthenticationToken user= new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
                System.out.println(user);

                SecurityContextHolder.getContext().setAuthentication(user);
                System.out.println(SecurityContextHolder.getContext().getAuthentication()); // userName
            }
        }
        doFilter(request,response,filterChain);
    }

}
