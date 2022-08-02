package com.gongzone.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;
import com.gongzone.order.service.OrderServiceImpl;


/**
 * ���� ��Ʈ�ѷ�
 * @author kangdonghyeon
 * @version 1.0
 * */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	public OrderServiceImpl orderService;
	
	/**
	 *  ��ü ���� ��ȸ
	 *  @return  List<Order>
	 */
	@GetMapping("/list")
	public List<Order> findOrder(){
		return orderService.findOrder();
	}
	
	
	/**
	 * ���� �ڵ�(orderId)�� ��ȸ
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@GetMapping("/{orderId}")
	public OrderDTO findOrderByOrderId(@PathVariable Long orderId) {
		return null;
	}
	
	
	/**
	 * ���� ���
	 * @param { OrderDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertOrder(@RequestBody OrderDTO orderDTO) {
		orderService.insertOrder(orderDTO);
	}
	
	
	/**
	 * ���� �ڵ�(order_id)�� ����
	 * @param { orderId, OrderDTO }
	 * @return void
	 * */
	@PutMapping("{orderId}")
	public void updateOrder(@PathVariable Long orderId, OrderDTO orderDTO) {
		orderService.updateOrder(orderDTO);
	}
	
	/**
	 * ���� �ڵ�(orderId)�� ����
	 * @param { orderId }
	 * @return void
	 * */
	@DeleteMapping("{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}
	
	
	
}
