package com.gongzone.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;
import com.gongzone.order.service.OrderServiceImpl;

@RestController
public class OrderController {
	@Autowired
	public OrderServiceImpl orderService;
	
	@GetMapping(value="/api/order/list")
	public List<Order> findOrder(){
		return orderService.findOrder();
	}
	
	@GetMapping(value="/api/order/{orderId}")
	public OrderDTO findOrderByOrderId(@PathVariable Long orderId) {
		return null;
	}
	
	@PostMapping(value="/api/order")
	public void insertOrder(OrderDTO orderDTO) {
		orderService.insertOrder(orderDTO);
	}
	
	@PutMapping(value="/api/order")
	public void updateOrder(OrderDTO orderDTO) {
		orderService.updateOrder(orderDTO);
	}
	
	
	@DeleteMapping(value="/api/order")
	public void deleteOrder(Long orderId) {
		orderService.deleteOrder(orderId);
	}
	
	
	
}
