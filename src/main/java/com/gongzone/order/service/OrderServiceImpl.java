package com.gongzone.order.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.dto.OrderUpdateDTO;
import com.gongzone.order.entity.Order;
import com.gongzone.order.mapper.OrderMapper;
import com.gongzone.order.repository.OrderRepository;


import lombok.RequiredArgsConstructor;

/**
 * 발주 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepo;
	private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
	
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderDTO>
	 */
	@Override
	public List<OrderDTO> findOrder() {
		List<OrderDTO> list = orderMapper.toDtoList(orderRepo.findAll());
		return list;
	}

	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@Override
	public OrderDTO findOrderByOrderId(Long orderId) {
			return toDTO(orderRepo.findOrderByOrderId(orderId));
		}

	
	
	/**
	 * 발주 등록
	 * @param { OrderDTO }
	 * @return void
	 * */
	@Override
	public void insertOrder(OrderDTO orderDTO) {
		orderRepo.save(toEntity(orderDTO));
		
	}

	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { OrderDTO }
	 * @return void
	 * */
	@Override
	public void updateOrder(Long orderId, OrderUpdateDTO updateDTO) {
		Order order = orderRepo.findOrderByOrderId(orderId);
		order.updateOrder(updateDTO);
		orderRepo.save(order);
	}

	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteOrder(Long orderId) {
		orderRepo.deleteOrderByOrderId(orderId);
	}

	/* MapStruct Mapper Production ↔ ProductionDTO */
	protected OrderDTO toDTO(Order order) {
		return orderMapper.toDto(order);
	}
	
	/* MapStruct Mapper ProductionDTO ↔ Production */
	protected Order toEntity(OrderDTO orderDto) {
		return orderMapper.toEntity(orderDto);
	}
	
}
	

