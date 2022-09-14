package com.gongzone.apiController.client;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.client.ClientInfoDto;
import com.gongzone.dto.client.ClientListDto;
import com.gongzone.dto.client.RegisterClientDto;
import com.gongzone.dto.client.UpdateClientDto;
import com.gongzone.service.implement.client.ClientServiceImple;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.annotations.ApiOperation;
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
	@GetMapping("/list")
	@Operation(summary = "전체 거래처 조회", description = "거래처 리스트 조회", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ClientListDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<List<ClientListDto>> findAllClient() {
		return ResponseEntity.ok().body(clientService.findAllClient());
	}
	
	/**
	 *  특정 거래처 조회
	 *  
	 *  @param clientId Long
	 *  @return List<EmployeeListDto>
	 */
	@GetMapping("{clientId}")
	@Operation(summary = "특정 거래처 조회", description = "특정 거래처 조회", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ClientInfoDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<ClientInfoDto> findByClientId(@Parameter(description = "거래처 코드") @PathVariable Long clientId) {
		return ResponseEntity.ok().body(clientService.findByClientId(clientId));
	}
	
	/**
	 *  거래처 등록
	 *  
	 *  @param ClientDto
	 *  @return success -> "등록 성공"
	 */
	@PostMapping("")
	@Operation(summary = "거래처 등록", description = "거래처 등록", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<Object> saveClient(@RequestBody @Validated final RegisterClientDto clientDto) {
		clientService.saveClient(clientDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	/**
	 * 거래처 수정
	 * 
	 * @throws IllegalAccessException
	 * @param clientId Long
	 * @param UpdateClientDto
	 * @return success -> "수정 성공"
	 */
	@PutMapping("{clientId}")
	@Operation(summary = "거래처 수정", description = "거래처 정보 수정", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(example = "수정 완료"))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<Object> updateClient(@Parameter(description = "거래처 코드") @PathVariable final Long clientId,
			@RequestBody @Validated final UpdateClientDto requestDto) {
		clientService.updateClient(clientId, requestDto);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * 거래처 삭제
	 * 
	 * @throws IllegalAccessException
	 * @param clientId Long
	 * @return success -> "삭제 성공"
	 */
	@DeleteMapping("{clientId}")
	@Operation(summary = "특정 거래처 삭제", description = "거래처 ID로 거래처 삭제", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(example = "삭제 완료"))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<Object> deleteClient(@Parameter(description = "거래처 코드") @PathVariable final Long clientId) throws IllegalAccessException {
		clientService.deleteClient(clientId);
		return ResponseEntity.noContent().build();
	}
}
