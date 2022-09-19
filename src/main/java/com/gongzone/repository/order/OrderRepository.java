package com.gongzone.repository.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.order.Order;
import com.gongzone.entity.order.OrderID;


/**
 * 발주 Repository
 * @author kangdonghyeon
 * @version 1.0
 * */
@Repository
public interface OrderRepository extends JpaRepository<Order, OrderID> {
	public Optional<Order> findOrderByOrderId(Long orderId);
	public List<Order> findAll();
	public Optional<Order> deleteOrderByOrderId(Long orderId);

}
