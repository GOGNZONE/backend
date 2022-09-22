package com.gongzone.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {

	private String grantType;
	private String accessToken;
	private Long tokenExpiresIn;
}
