package com.gongzone.bom.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;

@Repository
public interface BOMRepository extends JpaRepository<BOM, Long> {

	@Transactional
	public void deleteBOMByBomId(Long bomId);
	public BOM findBOMByBomId(Long bomId);


	

}
