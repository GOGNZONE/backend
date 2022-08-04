package com.gongzone.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.storage.entity.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 재고 Entity
 * @author kangdonghyeon
 * @version 1.0
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_stock")
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
	
	/**
	 * 재고 업데이트
	 * @param {stockName, stockQuantity, stockDescription}
	 * @return void
	 */
	public void updateStock(String stockName, Long stockQuantity, String stockDescription) {
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.stockDescription = stockDescription;
	}
	
	/**
	 * 재고 Entity를 재고DTO로 변환
	 * @param {Stock}
	 * @return StockDTO
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
