package com.gongzone.service.order;

import java.util.List;

import com.gongzone.dto.order.OrderDTO.OrderRequest;
import com.gongzone.dto.order.OrderDTO.OrderResponse;
import com.gongzone.dto.order.OrderListDTO;
import com.gongzone.dto.order.OrderUpdateDTO;

/**
 * 발주 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface OrderService {
	
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderListDTO>
	 */
	public List<OrderListDTO> findOrder();
	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	public OrderResponse findOrderByOrderId(Long orderId);
	
	/**
	 * 발주 등록
	 * @param { OrderDTO }
	 * @return void
	 * */
	public void insertOrder(OrderRequest orderDto);
	
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
