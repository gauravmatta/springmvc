package com.springimplant.jwt.api.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUtil {
	
		private static final long EXPIRE_DURATION=24*60*60*1000; //24 hrs
	 	
		@Value("${app.jwt.secret}")
		private String secret = "springimplant";
		
		@Autowired
		UserRepository userRepository;

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    
	    private Claims extractAllClaims(String token) {
	    	try {
	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	    	} catch(ExpiredJwtException ex) {
	    		log.error("JWT Expired", ex);
	    	} catch(IllegalArgumentException ex) {
	    		log.error("Token is null, empty or has only white space",ex);
	    	} catch (MalformedJwtException ex) {
	    		log.error("JWT is invalid");
	    	} catch (UnsupportedJwtException ex) {
	    		log.error("JWT is not supported", ex);
	    	} catch (SignatureException ex) {
	    		log.error("Signature Validation failed",ex);
	    	}
	    	return new DefaultClaims();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public String generateToken(String username) {
	        Map<String, Object> claims = new HashMap<>();
	        User user = userRepository.findByUserId(username).orElse(null);
	        if( user != null) {
	        	claims.put("created For", user.getFirstName() + " " + user.getLastName());
	        	claims.put("roles", user.getRoles().toString());
	        }
	        return createToken(claims, username);
	    }

	    private String createToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder()
	        		.setIssuer("JavaImplant")
	        		.setClaims(claims)
	        		.setSubject(subject)
	        		.setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
}