package com.gongzone.apiController.storage;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.storage.StorageDTO.StorageRequest;
import com.gongzone.dto.storage.StorageDTO.StorageResponse;
import com.gongzone.dto.storage.StorageUpdateDTO;
import com.gongzone.service.implement.storage.StorageServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


/**
 * 창고 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 * */


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storage")
@Tag(name = "STORAGE", description = "창고 API")
public class StorageController {

	private final StorageServiceImpl storageService;
	
	/**
	 *  전체 창고 조회
	 *  @return  List<StorageDTO>
	 */
	@Operation(summary = "창고 리스트 조회", description = "전체 창고 목록에 대한 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = StorageResponse.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/list")
	public List<StorageResponse> getStock(){
		return storageService.findStorage();
	}
	
	/**
	 * 창고 코드(storageId)로 조회
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@Operation(summary = "창고 상세 조회", description = "창고 코드로 조회하여 창고에 대한 상세 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = StorageResponse.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/{storageId}")
	public StorageResponse getStockbyid(@PathVariable Long storageId){
		return storageService.findStorageByStorageId(storageId);
	}
	
	
	/**
	 * 창고 등록
	 * @param { storageDTO }
	 * @return void
	 * */
	@Operation(summary = "창고 등록", description = "새로운 창고 데이터 입력")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
		@PostMapping("")
	public void insertStorage(@RequestBody StorageRequest request) {
		storageService.insertStorage(request);
	}
	
	/**
	 * 창고 수정(storageId)로 수정
	 * @param { storageId, storageDTO }
	 * @return void
	 * */
	@Operation(summary = "창고 수정", description = "창고 코드로 조회하여 창고에 대한 데이터 수정")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PutMapping("{storageId}")
	public void updateStorage(@PathVariable Long storageId ,@RequestBody StorageUpdateDTO updateDTO ) {
		storageService.updateStorage(storageId,updateDTO);
	}
	
	/**
	 * 창고 코드(storageId)로 삭제
	 * @param { storageId }
	 * @return void
	 * */
	@Operation(summary = "창고 삭제", description = "창고 코드로 조회하여 해당 발주 데이터 삭제")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@DeleteMapping("/{storageId}")
	public void deleteStorage(@PathVariable Long storageId) {
		storageService.deleteStorage(storageId);
	}
	
	
}
