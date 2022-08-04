package com.gongzone.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;
import com.gongzone.order.repository.OrderRepository;

/**
 * 발주 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	public OrderRepository orderRepo;
	
	
	/**
	 *  전체 발주 조회
	 *  @return  List<Order>
	 */
	@Override
	public List<Order> findOrder() {
		return orderRepo.findAll();
	}

	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@Override
	public OrderDTO findOrderByOrderId(Long orderId) {
		return orderRepo.findOrderByOrderId(orderId).toDTO(orderRepo.findOrderByOrderId(orderId));
	}

	
	
	/**
	 * 발주 등록
	 * @param { OrderDTO }
	 * @return void
	 * */
	@Override
	public void insertOrder(OrderDTO orderDTO) {
		System.out.println(orderDTO);
		Order orderEntity = orderDTO.toEntity(orderDTO);
		orderRepo.save(orderEntity);
		
	}

	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { OrderDTO }
	 * @return void
	 * */
	@Override
	public void updateOrder(OrderDTO orderDTO) {
		Order order = findOrderByOrderId(orderDTO.getOrderId()).toEntity(findOrderByOrderId(orderDTO.getOrderId()));
		order.updateOrder(orderDTO);
		orderRepo.save(order);
	}

	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	@Override
	public void deleteOrder(Long orderId) {
		orderRepo.deleteOrderByOrderId(orderId);
	}

}
