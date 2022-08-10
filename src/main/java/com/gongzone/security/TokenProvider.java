package com.gongzone.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.gongzone.entity.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenProvider {
	
	@Value("spring.jwt.secret")
	private String secretKey;
	
	public String create(Employee employee) {
		// 기한 : 지금으로 부터 1일로 설정
		Date expiryDate = Date.from(
				Instant.now()
				.plus(1, ChronoUnit.DAYS));
		
		// JWT Token 생성
		return Jwts.builder()
				// header에 들어갈 내용 및 서명을ㄹ 하기 위한 SECRET_KEY
				.signWith(SignatureAlgorithm.HS512, secretKey)
				// payload에 들어갈 내용
				.setSubject(employee.getEmployeeEmail())
				.setIssuer("gongzone app")
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.compact();
	}
	
	public String validateAndGetEmployeeEmail(String token) {
		Claims claims = Jwts.parser()
						.setSigningKey(secretKey)
						.parseClaimsJws(token)
						.getBody();
		
		return claims.getSubject();
		
	}
}
