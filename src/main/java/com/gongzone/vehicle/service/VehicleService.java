package com.gongzone.vehicle.service;

import java.util.List;

import com.gongzone.vehicle.dto.VehicleDto;

/**
 * 배송 차량 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface VehicleService {
	
	/**
	 * 전체 배차 차량 목록 조회
	 * @return List<VehicleDto>
	 * */
	public List<VehicleDto> findAllVehicles();
	
	/**
	 * 배차 차량 코드(vehicle_id)로 차량 조회
	 * @param { vehicleId }
	 * @return VehicleDto
	 * */
	public VehicleDto findByVehicleId(Long vehicleId);
	
	/**
	 * 배차 차량 등록
	 * @param { vehicleDto }
	 * @return void
	 * */
	public void insertVehicle(VehicleDto vehicleDto);
	
	/**
	 * 배차 차량 코드(vehicle_id)로 차량 수정
	 * @param { vehicleId, vehicleDto }
	 * @return void
	 * */
	public void updateVehicle(Long vehicleId, VehicleDto vehicleDto);
	
	/**
	 * 배치 차량 코드(vehicle_id)로 차량 삭제
	 * @param { vehicleId }
	 * @return void
	 * */
	public void deleteVehicle(Long vehicelId);
}
