package com.gongzone.stock.service;

import java.util.List;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;


/**
 * ��� ���� �������̽�
 * @author kangdonghyeon
 * @version 1.0
 */

public interface StockService {
	/**
	 *  ��ü ��� ��ȸ
	 *  @return List<ProductionDtoDetail>
	 */
	public List<Stock> findStock();
	

	/**
	 * ����ڵ�(stockId)�� ��ȸ
	 * @param { stockId }
	 * @return StockDTO
	 * */
	public StockDTO findStockByStockId(Long stockId);
	
	/**
	 * ��� ���
	 * @param { stockDTO }
	 * @return void
	 * */
	public void insertStock(StockDTO stockDTO);
	
	
	/**
	 * ��� �ڵ�(stockId)�� ����
	 * @param { stockId, stockDTO }
	 * @return void
	 * */
	public void updateStock(Long stockId, StockDTO stockDTO);
	
	
	/**
	 * ��� �ڵ�(stockId)�� ����
	 * @param { stockId }
	 * @return void
	 * */
	public void deleteStock(Long stockId);
}
