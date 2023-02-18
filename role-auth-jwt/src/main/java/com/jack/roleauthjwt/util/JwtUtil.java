package com.jack.roleauthjwt.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

	public String getUserNameFromToken(String token) {
		return null;
	}
	private <T> T getClaimFromToken(String token) {
		final Claims claim = getAllClaimsFromToken(token);
		return null;
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(Constants.jwt_secrets).parseClaimsJws(token).getBody();
	}
}
