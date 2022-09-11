package com.gongzone.apiController.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.client.AccountInfoDto.AccountInfoRequest;
import com.gongzone.dto.client.AccountInfoDto.AccountInfoResponse;
import com.gongzone.dto.client.UpdateAccountDto;
import com.gongzone.service.implement.client.ClientAccountServiceImpl;

//import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class ApiAccountController {

	private final ClientAccountServiceImpl accountService;

	/**
	 * 특정 계좌 조회
	 * 
	 * @param accountId Long
	 * @return AccountInfoDto
	 * @throws IllegalAccessException 
	 */
//	@ApiOperation(value = "특정 계좌 조회", notes = "특정 계좌 조회")
	@GetMapping("{accountId}")
	public ResponseEntity<AccountInfoResponse> findByAccountId(@PathVariable Long accountId) throws IllegalAccessException {
		return ResponseEntity.ok().body(accountService.findByAccountId(accountId));
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
	public ResponseEntity<String> saveAccount(@PathVariable Long clientId, @RequestBody AccountInfoRequest accountInfoDto) {
		accountService.saveAccount(clientId, accountInfoDto);
		return ResponseEntity.ok().body("등록성공");
	}

	/**
	 * 특정 거래처 계좌 수정
	 * 
	 * @param clientId       Long
	 * @param AccountDto
	 * @return success -> 수정 성공
	 * @throws IllegalAccessException 
	 */
//	@ApiOperation(value = "특정 계좌 수정", notes = "특정 계좌 수정")
	@PutMapping("{accountId}")
	public ResponseEntity<String> updateAccount(@PathVariable Long accountId, @RequestBody UpdateAccountDto accountDto) throws IllegalAccessException {
		accountService.updateAccount(accountId, accountDto);
		return ResponseEntity.ok().body("수정 성공");
	}

}
