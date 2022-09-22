package com.gongzone.apiController.client;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Tag(name = "CLIENT_ACCOUNT", description = "거래처 계좌 관련 API")
public class ApiAccountController {

	private final ClientAccountServiceImpl accountService;

	/**
	 * 특정 계좌 조회
	 * 
	 * @param accountId Long
	 * @return AccountInfoResponse
	 */
	@GetMapping("{accountId}")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	public ResponseEntity<AccountInfoResponse> findByAccountId(@Parameter(description = "거래처 계좌 코드") @PathVariable final Long accountId) {
		return ResponseEntity.ok().body(accountService.findByAccountId(accountId));
	}

	/**
	 * 특정 거래처 계좌 등록
	 * 
	 * @param clientId Long
	 * @param AccountInfoRequest
	 */
	@PostMapping("{clientId}")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	public ResponseEntity<Object> saveAccount(@Parameter(description = "거래처 계좌 코드") @PathVariable final Long clientId,
			@RequestBody @Validated final AccountInfoRequest accountInfoDto) {
		accountService.saveAccount(clientId, accountInfoDto);
		return ResponseEntity.noContent().build();
	}

	/**
	 * 특정 거래처 계좌 수정
	 * 
	 * @param clientId Long
	 * @param UpdateAccountDto
	 */
	@PutMapping("{accountId}")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	public ResponseEntity<Object> updateAccount(@PathVariable final Long accountId,
			@RequestBody @Validated final UpdateAccountDto accountDto) {
		accountService.updateAccount(accountId, accountDto);
		return ResponseEntity.noContent().build();
	}

}
