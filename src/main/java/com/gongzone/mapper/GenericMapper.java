package com.gongzone.mapper;

import java.util.List;

/**
 * 모든 Entity ↔ DTO 변환에 적용시킬 GenericMapper 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface GenericMapper<D, E> {
	D toDto(E e);
	E toEntity(D d);
	
	List<D> toDtoList(List<E> entityList);
	List<E> toEntityList(List<D> dtoList);
}