package com.gongzone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.gongzone.dto.StockDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Stock 엔티티
 * @author kangdonghyeon
 * @version 1.0
 */




@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {
	@Id
	@Column(name="stock_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	
	@NotNull
	@Column(name="stock_name")
	private String stockName;
	
	@NotNull
	@Column(name="stock_quantity")
	@ColumnDefault("0")
	private Long stockQuantity;
	
	@ColumnDefault("NULL")
	@Column(name="stock_description")
	private String stockDescription;
	
	@NotNull
	@JoinColumn(name = "fk_storage_id")
	@ManyToOne(targetEntity = Storage.class)
	private Storage storage;
	
	public void updateStock(String stockName, Long stockQuantity, String stockDescription) {
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.stockDescription = stockDescription;
	}
	
	
	/**
	 * Stock 수정
	 * @param {stockEntity}
	 * @return 값을 업데이트만 하기때문에 void
	 */
	
	
	
	public StockDTO toDTO(Stock stockEntity) {
		StockDTO stockDTO = StockDTO.builder()
				.stockId(stockEntity.getStockId())
				.stockName(stockEntity.getStockName())
				.stockQuantity(stockEntity.getStockQuantity())
				.stockDescription(stockEntity.getStockDescription())
				.storage(stockEntity.getStorage())
				.build();
		return stockDTO;
	}
	
	
	
}
