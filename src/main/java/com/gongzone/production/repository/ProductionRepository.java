package com.gongzone.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gongzone.production.entity.Production;

/**
 * 생산 리포지토리
 * @author Hanju Park
 * @version 1.0
 * */
public interface ProductionRepository extends JpaRepository<Production, Long>{

}
