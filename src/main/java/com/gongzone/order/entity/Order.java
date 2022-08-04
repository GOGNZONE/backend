package com.gongzone.order.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import com.gongzone.order.dto.OrderDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Order ��ƼƼ
 * @version 1.0
 * @author kangdonghyeon
 *
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`") // order�� ������ ``�ٿ��־���
public class Order {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name="order_production_file", length=80)
	@ColumnDefault("NULL")
	private String orderProuctionFile;
	
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
	private LocalDateTime orderDate;
	
	@Column(name="fk_client_id")
	private Long fkClientId;
	

	
	/**
	 * ���� ����
	 * @param {orderDTO}
	 * @return  void 
	 */
	public void updateOrder(OrderDTO orderDTO) {
		this.orderProductionName = orderDTO.getOrderProductionName();
		this.orderProductionBrandName = orderDTO.getOrderProductionBrandName();
		this.orderProductionPrice = orderDTO.getOrderProductionPrice();
		this.orderProductionQuantity = orderDTO.getOrderProductionQuantity();
		this.orderProuctionFile = orderDTO.getOrderProuctionFile();
		this.orderProductionStandard = orderDTO.getOrderProductionStandard();
		this.orderProductionUnit = orderDTO.getOrderProductionUnit();
		this.orderProductionDescription = orderDTO.getOrderProductionDescription();
		this.orderProductionEndDate = orderDTO.getOrderProductionEndDate();
	}
	
	
	/**
	 * OrderEntity�� OrderDTO�� ����
	 * @param {Order}
	 * @return OrderDTO
	 */
	
	public OrderDTO toDTO(Order OrderEntity) {
		OrderDTO orderDTO = OrderDTO.builder()
				.orderId(OrderEntity.getOrderId())
				.orderProductionName(OrderEntity.getOrderProductionName())
				.orderProductionBrandName(OrderEntity.getOrderProductionBrandName())
				.orderProductionPrice(OrderEntity.getOrderProductionPrice())
				.orderProductionQuantity(OrderEntity.getOrderProductionQuantity())
				.orderProuctionFile(OrderEntity.getOrderProuctionFile())
				.orderProductionStandard(OrderEntity.getOrderProductionStandard())
				.orderProductionUnit(OrderEntity.getOrderProductionUnit())
				.orderProductionDescription(OrderEntity.getOrderProductionDescription())
				.orderProductionEndDate(OrderEntity.getOrderProductionEndDate())
				.orderDate(OrderEntity.getOrderDate())
				.fkClientId(OrderEntity.getFkClientId())
				.build();
		
		return orderDTO;
	}
	
	
	
	
}
