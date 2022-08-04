package com.gongzone.order.service;

import java.util.List;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;

/**
 * 발주 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface OrderService {
	
	/**
	 *  전체 발주 조회
	 *  @return  List<Order>
	 */
	public List<Order> findOrder();
	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	public OrderDTO findOrderByOrderId(Long orderId);
	
	/**
	 * 발주 등록
	 * @param { OrderDTO }
	 * @return void
	 * */
	public void insertOrder(OrderDTO orderDTO);
	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { OrderDTO }
	 * @return void
	 * */
	public void updateOrder(OrderDTO orderDTO);
	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	public void deleteOrder(Long orderId);
}
