package com.gongzone.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gongzone.stock.entity.Stock;

/**
 * 재고 Repository
 * @author kangdonghyeon
 * @version 1.0
 */

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	public Stock findStockByStockId(Long stockId);
	public void deleteByStockId(Long stockId);
}
