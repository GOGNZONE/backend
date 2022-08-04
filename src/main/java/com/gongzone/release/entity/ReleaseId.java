package com.gongzone.release.entity;

import java.io.Serializable;

import com.gongzone.production.entity.Production;

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
