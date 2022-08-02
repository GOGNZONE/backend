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
 * 발주 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 * */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	public OrderServiceImpl orderService;
	
	/**
	 *  전체 발주 조회
	 *  @return  List<Order>
	 */
	@GetMapping("/list")
	public List<Order> findOrder(){
		return orderService.findOrder();
	}
	
	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@GetMapping("/{orderId}")
	public OrderDTO findOrderByOrderId(@PathVariable Long orderId) {
		return null;
	}
	
	
	/**
	 * 발주 등록
	 * @param { OrderDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertOrder(@RequestBody OrderDTO orderDTO) {
		orderService.insertOrder(orderDTO);
	}
	
	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { orderId, OrderDTO }
	 * @return void
	 * */
	@PutMapping("{orderId}")
	public void updateOrder(@PathVariable Long orderId, OrderDTO orderDTO) {
		orderService.updateOrder(orderDTO);
	}
	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	@DeleteMapping("{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}
	
	
	
}
