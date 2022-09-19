package com.gongzone.repository.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.entity.order.Order;
import com.gongzone.entity.order.OrderID;


/**
 * 발주 Repository
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface OrderRepository extends JpaRepository<Order, OrderID> {
	
	public Optional<Order> findOrderByOrderId(Long orderId);
	public List<Order> findAll();
	public Optional<Order> deleteOrderByOrderId(Long orderId);
	
	@Modifying
	@Query(value = "INSERT INTO t_order VALUES ("
			+ ":#{#order.orderId},"
			+ ":#{#order.orderDate},"
			+ ":#{#order.orderProductionBrandName},"
			+ ":#{#order.orderProductionDescription},"
			+ ":#{#order.orderProductionEndDate},"
			+ ":#{#order.orderProductionName},"
			+ ":#{#order.orderProductionPrice},"
			+ ":#{#order.orderProductionQuantity},"
			+ ":#{#order.orderProductionStandard},"
			+ ":#{#order.orderProductionUnit},"
			+ ":#{#order.client})", nativeQuery = true)
	@Transactional
	void saveOrder(@Param("order") Order order);

}
