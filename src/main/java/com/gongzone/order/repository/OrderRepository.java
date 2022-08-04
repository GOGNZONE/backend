package com.gongzone.order.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gongzone.order.entity.Order;


/**
 * 주문 Repository
 * @author kangdonghyeon
 * @version 1.0
 * */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	public Order findOrderByOrderId(Long orderId);

	public List<Order> findAll();

	public void deleteOrderByOrderId(Long orderId);

}
