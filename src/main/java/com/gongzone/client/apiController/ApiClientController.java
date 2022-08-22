package com.gongzone.client.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.client.dto.ClientDto;
import com.gongzone.client.dto.ClientInfoDto;
import com.gongzone.client.dto.ClientListDto;
import com.gongzone.client.dto.UpdateClientDto;
import com.gongzone.client.service.ClientServiceImple;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ApiClientController {
	
	private final ClientServiceImple clientService;
	
	/**
	 *  전체 거래처 조회
	 *  @return List<EmployeeListDto>
	 */
//	@ApiOperation(value = "전체 거래처 조회", notes = "전체 거래처 조회")
	@GetMapping("/list")
	public ResponseEntity<List<ClientListDto>> findAllClient() {
		return ResponseEntity.ok(clientService.findAllClient());
	}
	
	/**
	 *  특정 거래처 조회
	 *  
	 *  @throws IllegalAccessException
	 *  @param clientId Long
	 *  @return List<EmployeeListDto>
	 */
//	@ApiOperation(value = "특정 거래처 조회", notes = "특정 거래처 조회")
	@GetMapping("{clientId}")
	public ResponseEntity<ClientInfoDto> findByClientId(@PathVariable Long clientId) {
		try {
			return ResponseEntity.ok(clientService.findByClientId(clientId));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  거래처 등록
	 *  
	 *  @throws IllegalAccessException
	 *  @param ClientDto
	 *  @return success -> "등록 성공"
	 */
//	@ApiOperation(value = "거래처 등록", notes = "거래처 등록")
	@PostMapping("")
	public ResponseEntity<String> saveClient(@RequestBody ClientDto clientDto) {
		try {
			clientService.saveClient(clientDto);
		} catch (Exception e) {
			e.printStackTrace();
			// log 생성
		}
		return ResponseEntity.ok("등록 성공");
	}
	
	/**
	 * 거래처 수정
	 * 
	 * @throws IllegalAccessException
	 * @param clientId Long
	 * @param UpdateClientDto
	 * @return success -> "수정 성공"
	 */
//	@ApiOperation(value = "특정 거래처 수정", notes = "특정 거래처 수정")
	@PutMapping("{clientId}")
	public ResponseEntity<String> updateClient(@PathVariable Long clientId, @RequestBody UpdateClientDto requestDto) {
		try {
			clientService.updateClient(clientId, requestDto);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			// log 생성
		}
		return ResponseEntity.ok("수정 성공");
	}
	
	/**
	 * 거래처 삭제
	 * 
	 * @throws IllegalAccessException
	 * @param clientId Long
	 * @return success -> "수정 성공"
	 */
//	@ApiOperation(value = "거래처 삭제", notes = "거래처 삭제")
	@DeleteMapping("{clientId}")
	public ResponseEntity<String> deleteClient(@PathVariable Long clientId) {
		try {
			clientService.deleteClient(clientId);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			// log생성
		}
		return ResponseEntity.ok("삭제 성공");
		
	}
}
