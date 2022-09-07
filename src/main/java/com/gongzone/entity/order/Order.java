package com.gongzone.entity.order;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.entity.client.Client;
import com.gongzone.order.dto.OrderUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 발주 엔티티
 * @version 1.0
 * @author kangdonghyeon
 *
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_order")
@IdClass(OrderID.class)
public class Order implements Persistable<Long> {
	
	@Id
	@Column(name="order_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name="order_production_name", length=30)
	@NotNull
	private String orderProductionName;
	
	@Column(name="order_production_brand_name", length=30)
	@ColumnDefault("NULL")
	private String orderProductionBrandName;
	
	@Column(name="order_production_price", length=30)
	@ColumnDefault("0")
	@NotNull
	private Long orderProductionPrice;
	
	@Column(name="order_production_quantity", length=6)
	@ColumnDefault("0")
	@NotNull(message = "orderProductionQuantity must not be null")
	private int orderProductionQuantity;
	
	@Column(name="order_production_standard", length=10)
	@ColumnDefault("NULL")
	private String orderProductionStandard;
	
	@Column(name="order_production_unit", length=10)
	@ColumnDefault("NULL")
	private String orderProductionUnit;
	
	@Column(name="order_production_description")
	@ColumnDefault("NULL")
	private String orderProductionDescription;
	
	@Column(name="order_production_end_date")
	@NotNull(message = "orderProductionEndDate must not be null")
	private String orderProductionEndDate;
	
	@CreatedDate
	@Column(name="order_date")
	@NotNull(message = "orderDate must not be null")
	private LocalDate orderDate;
	
	@Id
	@JoinColumn(name="fk_client_id",nullable = true)
	@JsonIgnore
	@ManyToOne
	private Client client;

	/**
	 * 발주 수정
	 * @param {orderDTO}
	 * @return  void 
	 */
	public void updateOrder(OrderUpdateDTO updateDTO) {
		this.orderProductionName = updateDTO.getOrderProductionName();
		this.orderProductionBrandName = updateDTO.getOrderProductionBrandName();
		this.orderProductionPrice = updateDTO.getOrderProductionPrice();
		this.orderProductionQuantity = updateDTO.getOrderProductionQuantity();
		this.orderProductionStandard = updateDTO.getOrderProductionStandard();
		this.orderProductionUnit = updateDTO.getOrderProductionUnit();
		this.orderProductionDescription = updateDTO.getOrderProductionDescription();
		this.orderProductionEndDate = updateDTO.getOrderProductionEndDate();
	}

	@Override
	public Long getId() {
		return orderId;
	}

	@Override
	public boolean isNew() {
		return this.orderDate == null;
	}
}
