package com.gongzone.entity.stock;

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

import com.gongzone.entity.storage.Storage;

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
	public void updateStock(String stockName, Long stockQuantity, String stockDescription ) {
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.stockDescription = stockDescription;
	}
	
	public void updateStock2(String stockName, Long stockQuantity, String stockDescription,Storage storage ) {
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.stockDescription = stockDescription;
		this.storage = storage;
	}
	
	
}
