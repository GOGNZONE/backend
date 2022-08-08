package com.gongzone.stock.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;


/**
 * 재고 DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */

@Mapper(componentModel = "spring")
public interface StockMapper extends GenericMapper<StockDTO, Stock> {

}
