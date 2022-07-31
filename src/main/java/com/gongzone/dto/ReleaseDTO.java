package com.gongzone.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 출고 목록 페이지 DTO
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReleaseDTO {

	private Long releaseId;
	
	private LocalDate releaseDate;
	
	private int releaseQuantity;
	
	private String releaseType;
	
}
