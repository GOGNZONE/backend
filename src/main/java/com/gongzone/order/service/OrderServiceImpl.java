package com.gongzone.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;
import com.gongzone.order.repository.OrderRepository;

/**
 * ���� ���� �������̽� ����ü
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	public OrderRepository orderRepo;
	
	
	/**
	 *  ��ü ���� ��ȸ
	 *  @return  List<Order>
	 */
	@Override
	public List<Order> findOrder() {
		return orderRepo.findAll();
	}

	
	/**
	 * ���� �ڵ�(orderId)�� ��ȸ
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@Override
	public OrderDTO findOrderByOrderId(Long orderId) {
		return orderRepo.findOrderByOrderId(orderId).toDTO(orderRepo.findOrderByOrderId(orderId));
	}

	
	
	/**
	 * ���� ���
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
	 * ���� �ڵ�(order_id)�� ����
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
	 * ���� �ڵ�(orderId)�� ����
	 * @param { orderId }
	 * @return void
	 * */
	@Override
	public void deleteOrder(Long orderId) {
		orderRepo.deleteOrderByOrderId(orderId);
	}

}
