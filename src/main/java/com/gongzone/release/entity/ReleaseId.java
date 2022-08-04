package com.gongzone.release.entity;

import java.io.Serializable;

import com.gongzone.production.entity.Production;

/**
 * Production 엔티티와 Release 엔티티 식별관계에 의한 맵핑(복합키)
 * @author Hanju Park
 * @version 1.0
 * */
public class ReleaseId implements Serializable {
	
	private static final long serialVersionUID = -2929789292155268166L;
	
	private Long releaseId;
	
	private Production production;
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
