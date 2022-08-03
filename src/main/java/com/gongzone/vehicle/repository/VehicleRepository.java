package com.gongzone.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gongzone.vehicle.entity.Vehicle;

/**
 * 배송 차량 리포지토리
 * @author Hanju Park
 * @version 1.0
 * */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
