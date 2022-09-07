package com.gongzone.stock.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.stock.Stock;
import com.gongzone.stock.dto.StockDTO;


/**
 * 재고 DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */

@Mapper(componentModel = "spring")
public interface StockMapper extends GenericMapper<StockDTO, Stock> {

}
