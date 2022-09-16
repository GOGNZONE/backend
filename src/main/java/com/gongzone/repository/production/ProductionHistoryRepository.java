package com.gongzone.repository.production;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.entity.production.ProductionHistory;
import com.gongzone.entity.production.ProductionHistoryId;

/**
 * 생산 이력 리포지토리
 * @author Hanju Park
 * @version 1.0
 * */
public interface ProductionHistoryRepository extends JpaRepository<ProductionHistory, ProductionHistoryId>{
	
	@Modifying
	@Query(value = "INSERT INTO t_production_history VALUES (:#{#productionHistory.productionHistoryId}, :#{#productionHistory.productionHistoryCorrectionDate}, :#{#productionHistory.productionHistoryDescription}, :#{#productionHistory.productionHistoryType}, :#{#productionHistory.production}) ", nativeQuery = true)
	@Transactional
	void saveProductionHistory(@Param("productionHistory") ProductionHistory productionHistory);
	
}
