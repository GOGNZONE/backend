package com.gongzone.service.implement.order;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.order.Order;
import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.dto.OrderListDTO;
import com.gongzone.order.dto.OrderUpdateDTO;
import com.gongzone.order.mapper.OrderListMapper;
import com.gongzone.order.mapper.OrderMapper;
import com.gongzone.repository.client.ClientRepository;
import com.gongzone.repository.order.OrderRepository;
import com.gongzone.service.order.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 발주 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
@ToString
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepo;
	private final ClientRepository clientRepo;
	private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
	private final OrderListMapper orderListMapper = Mappers.getMapper(OrderListMapper.class);
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderDTO>
	 */
	@Override
	public List<OrderListDTO> findOrder() {
		List<Order> list = orderRepo.findAll();
		return orderListMapper.toDtoList(list);
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
	 * @param {  OrderDTO }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertOrder(OrderDTO orderDto) {
		Client client = clientRepo.findById(orderDto.getClient().getClientId()).orElse(null);
		orderDto.setClient(client);
		Order order = toEntity(orderDto);
		orderRepo.save(order);
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
	

