package com.gongzone.repository.stock;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.stock.Stock;

/**
 * 재고 Repository
 * @author kangdonghyeon
 * @version 1.0
 */

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	public Optional<Stock> findStockByStockId(Long stockId);
	public Optional<Stock> deleteByStockId(Long stockId);
}
