package com.gongzone.order.service;

import java.util.List;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;

/**
 * ���� ���� �������̽�
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface OrderService {
	
	/**
	 *  ��ü ���� ��ȸ
	 *  @return  List<Order>
	 */
	public List<Order> findOrder();
	
	/**
	 * ���� �ڵ�(orderId)�� ��ȸ
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	public OrderDTO findOrderByOrderId(Long orderId);
	
	/**
	 * ���� ���
	 * @param { OrderDTO }
	 * @return void
	 * */
	public void insertOrder(OrderDTO orderDTO);
	
	/**
	 * ���� �ڵ�(order_id)�� ����
	 * @param { OrderDTO }
	 * @return void
	 * */
	public void updateOrder(OrderDTO orderDTO);
	
	/**
	 * ���� �ڵ�(orderId)�� ����
	 * @param { orderId }
	 * @return void
	 * */
	public void deleteOrder(Long orderId);
}
