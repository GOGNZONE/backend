package com.gongzone.stock.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.stock.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	public List<Stock> findAll();
	public Stock findStockByStockId(Long stockId);
	
	@Transactional
	public void deleteByStockId(Long stockId);
}
