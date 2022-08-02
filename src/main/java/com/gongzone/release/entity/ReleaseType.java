package com.gongzone.release.entity;

import lombok.RequiredArgsConstructor;

/**
 * 출고 방식 열거형
 * @author Hanju Park
 * @version 1.0
 * */
@RequiredArgsConstructor
public enum ReleaseType {
	
	VEHICLE("배송"), DELIVERY("택배");
	
	private final String releaseType;
	
	public String getReleaseType() {
		return this.releaseType; 
	}
	
}
