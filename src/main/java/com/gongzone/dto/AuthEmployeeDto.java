package com.gongzone.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthEmployeeDto extends User {

	private static final long serialVersionUID = 1L;
	
	private String employeeEmail;
	private String employeePassword;
	private String employeeName;

	public AuthEmployeeDto(String username, String password, 
			Collection<? extends GrantedAuthority> authorities, 
			Map<String, Object> attr) {
		this(username, password, authorities);
}

	public AuthEmployeeDto(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.employeeEmail = username;
		this.employeePassword = password;
	}
	
}
