package com.gongzone.bom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gongzone.bom.entity.BOM;

/**
 * BOM Repository
 * @author kangdonghyeon
 * @version 1.0
 * */
@Repository
public interface BOMRepository extends JpaRepository<BOM, Long> {
	public void deleteBOMByBomId(Long bomId);
	public BOM findBOMByBomId(Long bomId);
}
