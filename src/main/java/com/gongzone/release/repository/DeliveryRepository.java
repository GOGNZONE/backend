package com.gongzone.release.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gongzone.release.entity.Delivery;

/**
 * 택배 리포지토리
 * @author Hanju Park
 * @version 1.0
 * */
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
