package com.gongzone.release.entity;

import java.io.Serializable;

import com.gongzone.production.entity.Production;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Production 엔티티와 Release 엔티티 식별관계에 의한 맵핑(복합키)
 * @author Hanju Park
 * @version 1.0
 * */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ReleaseId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long releaseId;
	
	private Production production;
	
}
