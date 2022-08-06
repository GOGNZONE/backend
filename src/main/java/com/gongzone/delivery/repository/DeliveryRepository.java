package com.gongzone.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gongzone.delivery.entity.Delivery;

/**
 * 배송 리포지토리
 * @author Hanju Park
 * @version 1.0
 * */
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
