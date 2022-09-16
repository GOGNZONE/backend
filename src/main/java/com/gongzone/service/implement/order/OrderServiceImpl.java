package com.gongzone.service.implement.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.dto.order.OrderDTO.OrderRequest;
import com.gongzone.dto.order.OrderDTO.OrderResponse;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;

import com.gongzone.dto.order.OrderListDTO;
import com.gongzone.dto.order.OrderUpdateDTO;
import com.gongzone.entity.client.Client;
import com.gongzone.entity.order.Order;
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
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderDTO>
	 */
	@Override
	@Transactional
	public List<OrderListDTO> findOrder() {
		List<OrderListDTO> orders = orderRepo.findAll()
				.stream()
				.map(OrderListDTO::new)
				.collect(Collectors.toList());
		return orders;
	}

	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param orderId 
	 * @return OrderDTO
	 * */
	@Override
	@Transactional
	public OrderResponse findOrderByOrderId(Long orderId) {
		Order order = orderRepo.findOrderByOrderId(orderId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		return new OrderResponse(order);
		}
	
	/**
	 * 발주 등록
	 * @param  { OrderRequest }
	 * @return void 
	 * @throws RESOURCE_NOT_FOUND
	 * */
	@Override
	@Transactional
	public void insertOrder(OrderRequest orderDto) {
		Client client = clientRepo.findById(orderDto.getClient().getClientId())
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		orderDto.setClient(client);
		orderRepo.save(orderDto.toEntity());
	}

	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { OrderUpdateDTO }, orderId
	 * @return void
	 * */
	@Override
	@Transactional
	public void updateOrder(Long orderId, OrderUpdateDTO updateDTO) {
		Order order = orderRepo.findOrderByOrderId(orderId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		order.updateOrder(updateDTO.toEntity());
//		orderRepo.save(order);
	}

	/**
	 * 발주 코드(orderId)로 삭제
	 * @param orderId
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteOrder(Long orderId) {
		orderRepo.deleteOrderByOrderId(orderId)
		.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
	}
}
	

