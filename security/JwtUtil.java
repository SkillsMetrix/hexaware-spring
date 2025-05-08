package com.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {
	private final String JWT_SECRET="mysecretkey";
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60))
				.signWith(SignatureAlgorithm.HS256, JWT_SECRET)
				.compact();
	}
	public String extractUserName(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}
	public boolean validateToken(String token,UserDetails userDetails) {
		String username=extractUserName(token);
		return username.equals(userDetails.getUsername());
	}

}
