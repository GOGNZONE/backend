package com.gongzone.vehicle.apiController;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.vehicle.dto.VehicleDto;
import com.gongzone.vehicle.service.VehicleServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 배송 차량 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicle")
public class VehicleRestController {

	private final VehicleServiceImpl vehicleServiceImpl;
	
	/**
	 * 전체 배차 차량 목록 조회
	 * @return List<VehicleDto>
	 * */
	@GetMapping("/list")
	public List<VehicleDto> findAllVehicles() {
		return vehicleServiceImpl.findAllVehicles();
	}
	
	/**
	 * 배차 차량 코드(vehicle_id)로 차량 조회
	 * @param { vehicleId }
	 * @return VehicleDto
	 * */
	@GetMapping("/{vehicleId}")
	public VehicleDto findByVehicleId(@PathVariable Long vehicleId) {
		return vehicleServiceImpl.findByVehicleId(vehicleId);
	}
	
	/**
	 * 배차 차량 등록
	 * @param { vehicleDto }
	 * @return void
	 * */
	@PostMapping("")
	public void insertVehicle(@Validated @RequestBody final VehicleDto vehicleDto) {
		log.info("@param vehicleDto : {}", vehicleDto);
		vehicleServiceImpl.insertVehicle(vehicleDto);
	}
	
	/**
	 * 배차 차량 코드(vehicle_id)로 차량 수정
	 * @param { vehicleId, vehicleDto }
	 * @return void
	 * */
	@PutMapping("/{vehicleId}")
	public void updateVehicle(@PathVariable Long vehicleId, @Validated @RequestBody final VehicleDto vehicleDto) {
		log.info("@param vehicleId : {}", vehicleId);
		log.info("@param vehicleDto : {}", vehicleDto);
		vehicleServiceImpl.updateVehicle(vehicleId, vehicleDto);
	}
	
	/**
	 * 배치 차량 코드(vehicle_id)로 차량 삭제
	 * @param { vehicleId }
	 * @return void
	 * */
	@DeleteMapping("/{vehicleId}")
	public void deleteVehicle(@PathVariable Long vehicleId) {
		vehicleServiceImpl.deleteVehicle(vehicleId);
	}
	
}
