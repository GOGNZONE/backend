package com.gongzone.stock.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.stock.dto.StockUpdateDTO;
import com.gongzone.stock.entity.Stock;

/**
 * 재고업데이트 DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface StockUpdateMapper extends GenericMapper<StockUpdateDTO, Stock> {

}
