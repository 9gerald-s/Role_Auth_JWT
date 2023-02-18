package com.jack.roleauthjwt.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtRequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String header = request.getHeader("Auth");
	
		String jwtToken = null;
		if(header != null && header.startsWith("Bearer ")) {
			jwtToken = header.substring(7);
			
			try {
				
			}catch(IllegalArgumentException e) {
				System.out.println("Unable to get jwt token");
			}catch(ExpiredJwtException e) {
				System.out.println("JWT token is expired");
			}
		}
	}

}
