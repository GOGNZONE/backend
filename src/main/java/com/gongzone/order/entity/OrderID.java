package com.gongzone.order.entity;

import java.io.Serializable;
import com.gongzone.client.entity.Client;



/**
 * Order 엔티티와 Client 엔티티 식별관계에 의한 맵핑(복합키)
 * @author kangdonghyeon
 * @version 1.0
 * */

public class OrderID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3439222336493519285L;

	private Long orderId; 
	
	private Client client; 
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
