package com.gongzone.vehicle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.vehicle.dto.VehicleDto;
import com.gongzone.vehicle.entity.Vehicle;
import com.gongzone.vehicle.mapper.VehicleMapper;
import com.gongzone.vehicle.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 배송 차량 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
	
	private final VehicleRepository vehicleRepository;
	private final VehicleMapper vehicleMapper;
	
	/**
	 * 전체 배차 차량 목록 조회
	 * @return List<VehicleDto>
	 * */
	@Override
	@Transactional(readOnly = true)
	public List<VehicleDto> findAllVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicleMapper.toDtoList(vehicles);
	}

	/**
	 * 배차 차량 코드(vehicle_id)로 차량 조회
	 * @param { vehicleId }
	 * @return VehicleDto
	 * */
	@Override
	@Transactional(readOnly = true)
	public VehicleDto findByVehicleId(Long vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
		return toDto(vehicle);
	}
	
	/**
	 * 배차 차량 등록
	 * @param { vehicleDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertVehicle(VehicleDto vehicleDto) {
		vehicleRepository.save(toEntity(vehicleDto));
	}

	/**
	 * 배차 차량 코드(vehicle_id)로 차량 수정
	 * @param { vehicleId, vehicleDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void updateVehicle(Long vehicleId, VehicleDto vehicleDto) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
		log.info("vehicle = {}", vehicle);
		vehicle.updateVehicle(vehicleDto);
	}

	/**
	 * 배치 차량 코드(vehicle_id)로 차량 삭제
	 * @param { vehicleId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteVehicle(Long vehicelId) {
		Vehicle vehicle = vehicleRepository.findById(vehicelId).orElse(null);
		log.info("vehicle = {}", vehicle);
		vehicleRepository.delete(vehicle);
	}

	
	/* MapStruct Mapper Vehicle ↔ VehicleDto */
	protected VehicleDto toDto(Vehicle vehicle) {
		return vehicleMapper.toDto(vehicle);
	}
	
	/* MapStruct Mapper VehicleDto ↔ Vehicle */
	protected Vehicle toEntity(VehicleDto vehicleDto) {
		return vehicleMapper.toEntity(vehicleDto);
	}
	
}
