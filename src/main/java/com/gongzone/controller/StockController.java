package com.gongzone.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController  //JSON을 반환하는 컨트롤러
public class StockController {
	@GetMapping(value="/")
	public int getStock(){;
		return 0;
		
	}
}
