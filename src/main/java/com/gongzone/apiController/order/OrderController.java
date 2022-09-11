package com.gongzone.apiController.order;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.order.OrderDTO.OrderRequest;
import com.gongzone.dto.order.OrderDTO.OrderResponse;
import com.gongzone.dto.order.OrderListDTO;
import com.gongzone.dto.order.OrderUpdateDTO;
import com.gongzone.service.implement.order.OrderServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


/**
 * 발주 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 * */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "ORDER", description = "발주 API")
public class OrderController {
	
	private final OrderServiceImpl orderService;
	
	/**
	 *  전체 발주 조회
	 *  @return  List<OrderDTO>
	 */
	
	@Operation(summary = "발주 리스트 조회", description = "전체 발주 목록에 대한 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = OrderListDTO.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/list")
	public List<OrderListDTO> findOrder(){
		return orderService.findOrder();
	}
	
	
	/**
	 * 발주 코드(orderId)로 조회
	 * @param { orderId }
	 * @return OrderDTO
	 * */
	@Operation(summary = "발주 상세 조회", description = "발주 코드로 조회하여 발주에 대한 상세 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = OrderResponse.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/{orderId}")
	public OrderResponse findOrderByOrderId(@PathVariable Long orderId) {
		return orderService.findOrderByOrderId(orderId);
	}
	
	
	/**
	 * 발주 등록
	 * @param { OrderDTO }
	 * @return void
	 * */
	@Operation(summary = "발주 등록", description = "새로운 발주 데이터 입력")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PostMapping("")
	public void insertOrder(@RequestBody OrderRequest orderDto) {
		orderService.insertOrder(orderDto);
	}
	
	
	/**
	 * 발주 코드(order_id)로 수정
	 * @param { orderId, OrderDTO }
	 * @return void
	 * */
	@Operation(summary = "발주 수정", description = "발주 코드로 조회하여 발주에 대한 데이터 수정")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PutMapping("/{orderId}")
	public void updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateDTO updateDto) {
		orderService.updateOrder(orderId, updateDto);
	}
	
	/**
	 * 발주 코드(orderId)로 삭제
	 * @param { orderId }
	 * @return void
	 * */
	@Operation(summary = "발주 삭제", description = "발주 코드로 조회하여 해당 발주 데이터 삭제")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
	}
	
	
	
}
