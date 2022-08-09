package com.gongzone.order.service;

import java.util.List;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.dto.OrderListDTO;
import com.gongzone.order.dto.OrderUpdateDTO;
/**
 * 발주 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface OrderService {
	
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderDTO>
	 */
	public List<OrderListDTO> findOrder();
	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	public OrderDTO findOrderByOrderId(Long orderId);
	
	/**
	 * 거래처 코드로(clientId) 발주 등록
	 * @param { clientId, OrderDTO }
	 * @return void
	 * */
	public void insertOrder(Long clientId, OrderDTO orderDto);
	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { orderId, OrderDTO }
	 * @return void
	 * */
	public void updateOrder(Long orderId, OrderUpdateDTO updateDTO);
	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	public void deleteOrder(Long orderId);
}
