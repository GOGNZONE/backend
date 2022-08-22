package com.gongzone.client.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.client.dto.AccountDto;
import com.gongzone.client.dto.AccountInfoDto;
import com.gongzone.client.service.ClientAccountServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class ApiAccountController {

	private final ClientAccountServiceImpl accountService;

	/**
	 * 전체 계좌 조회
	 * 
	 * @return List<AccountDto>
	 */
//	@ApiOperation(value = "전체 계좌 조회", notes = "전체 계좌 조회")
	@GetMapping("/list")
	public ResponseEntity<List<AccountDto>> findAllClient() {
		return ResponseEntity.ok(accountService.findAllClientAccount());
	}

	/**
	 * 특정 계좌 조회
	 * 
	 * @param accountId Long
	 * @return AccountInfoDto
	 */
//	@ApiOperation(value = "특정 계좌 조회", notes = "특정 계좌 조회")
	@GetMapping("{accountId}")
	public ResponseEntity<AccountInfoDto> findByAccountId(@PathVariable Long accountId) {
		try {
			return ResponseEntity.ok(accountService.findByAccountId(accountId));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			// log 처리
		}
		return null;
	}

	/**
	 * 특정 거래처 계좌 등록
	 * 
	 * @param clientId       Long
	 * @param AccountInfoDto
	 * @return success -> 등록성공
	 */
//	@ApiOperation(value = "특정 계좌 등록", notes = "특정 계좌 등록")
	@PostMapping("{clientId}")
	public ResponseEntity<String> saveAccount(@PathVariable Long clientId, @RequestBody AccountInfoDto accountInfoDto) {
		try {
			accountService.saveAccount(clientId, accountInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
			// log
		}
		return ResponseEntity.ok("등록성공");

	}

	/**
	 * 특정 거래처 계좌 수정
	 * 
	 * @param clientId       Long
	 * @param AccountDto
	 * @return success -> 수정 성공
	 */
//	@ApiOperation(value = "특정 계좌 수정", notes = "특정 계좌 수정")
	@PutMapping("{accountId}")
	public ResponseEntity<String> updateAccount(@PathVariable Long accountId, @RequestBody AccountDto accountDto) {
		try {
			accountService.updateAccount(accountId, accountDto);
		} catch(Exception e) {
			e.printStackTrace();
			// log
		}
		return ResponseEntity.ok("수정 성공");
	}

	/**
	 * 특정 거래처 계좌 삭제
	 * 
	 * @param clientId       Long
	 * @return success -> 삭제 성공
	 */
//	@ApiOperation(value = "특정 계좌 삭제", notes = "특정 계좌 삭제")
	@DeleteMapping("{accountId}")
	public ResponseEntity<String> updateAccount(@PathVariable Long accountId) {
		try {
			accountService.deleteAccount(accountId);
		} catch(Exception e) {
			e.printStackTrace();
			// log
		}
		return ResponseEntity.ok("삭제 성공");
	}
}
