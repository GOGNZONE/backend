package com.gongzone.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController  //JSON�� ��ȯ�ϴ� ��Ʈ�ѷ�
public class StockController {
	@GetMapping(value="/api/stock/list")
	public int getStock(){;
		return 1;
		
	}
}