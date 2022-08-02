package com.gongzone.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;
import com.gongzone.order.repository.OrderRepository;
import com.gongzone.storage.entity.Storage;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	public OrderRepository orderRepo;
	
	@Override
	public List<Order> findOrder() {
		return orderRepo.findAll();
	}

	@Override
	public OrderDTO findOrderByOrderId(Long orderId) {
		return orderRepo.findOrderByOrderId(orderId).toDTO(orderRepo.findOrderByOrderId(orderId));
	}

	@Override
	public void insertOrder(OrderDTO orderDTO) {
		Order orderEntity = orderDTO.toEntity(orderDTO);
		orderRepo.save(orderEntity);
		
	}

	@Override
	public void updateOrder(OrderDTO orderDTO) {
		Order order = findOrderByOrderId(orderDTO.getOrderId()).toEntity(findOrderByOrderId(orderDTO.getOrderId()));
		order.updateOrder(orderDTO);
		orderRepo.save(order);
	}

	@Override
	public void deleteOrder(Long orderId) {
		orderRepo.deleteOrderByOrderId(orderId);
	}

}
