package com.gongzone.order.entity;

import java.io.Serializable;
import com.gongzone.client.entity.Client;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * Order 엔티티와 Client 엔티티 식별관계에 의한 맵핑(복합키)
 * @author kangdonghyeon
 * @version 1.0
 * */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class OrderID implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long orderId;
	
	private Client client; 
	
}
