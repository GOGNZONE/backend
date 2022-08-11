package com.gongzone.order.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.dto.OrderListDTO;
import com.gongzone.order.dto.OrderUpdateDTO;
import com.gongzone.order.service.OrderServiceImpl;

import lombok.RequiredArgsConstructor;


/**
 * 발주 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 * */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	
	private final OrderServiceImpl orderService;
	
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderDTO>
	 */
	@GetMapping("/list")
	public List<OrderListDTO> findOrder(){
		return orderService.findOrder();
	}
	
	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@GetMapping("/{orderId}")
	public OrderDTO findOrderByOrderId(@PathVariable Long orderId) {
		return orderService.findOrderByOrderId(orderId);
	}
	
	
	/**
	 * 거래처 코드로(clientId) 발주 등록
	 * @param { clientId, OrderDTO }
	 * @return void
	 * */
	@PostMapping("/{clientId}")
	public void insertOrder(@PathVariable Long clientId,@RequestBody OrderDTO orderDto) {
		orderService.insertOrder(clientId, orderDto);
	}
	
	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { orderId, OrderDTO }
	 * @return void
	 * */
	@PutMapping("/{orderId}")
	public void updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateDTO updateDto) {
		orderService.updateOrder(orderId, updateDto);
	}
	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}
	
	
	
}