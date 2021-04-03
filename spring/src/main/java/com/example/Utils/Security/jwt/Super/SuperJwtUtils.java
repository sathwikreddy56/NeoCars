package com.example.Utils.Security.jwt.Super;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.Utils.Security.Admin.AdminDetailsImpl;

import io.jsonwebtoken.*;

@Component
public class SuperJwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(SuperJwtUtils.class);

	@Value("${bezkoder.app.jwtSecret}")
	private static String jwtSecret="$sec#ret$";

	@Value("${bezkoder.app.jwtExpirationMs}")
	private static int jwtExpirationMs=8460000;

	public static String generateJwtToken(Authentication authentication) {
		System.out.println(jwtSecret+" "+jwtExpirationMs);
		AdminDetailsImpl userPrincipal = (AdminDetailsImpl) authentication.getPrincipal();
		System.out.println(Arrays.toString(userPrincipal.getAuthorities().toArray()));
		return Jwts.builder()
				.setSubject((userPrincipal.getEmail()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}