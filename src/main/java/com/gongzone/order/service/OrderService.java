package com.gongzone.order.service;

import java.util.List;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;

public interface OrderService {
	public List<Order> findOrder();
	public OrderDTO findOrderByOrderId(Long orderId);
	public void insertOrder(OrderDTO orderDTO);
	public void updateOrder(OrderDTO orderDTO);
	public void deleteOrder(Long orderId);
}
