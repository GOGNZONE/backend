package com.gongzone.stock.mapper;

import com.gongzone.stock.dto.StockUpdateDTO;
import com.gongzone.stock.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T17:12:25+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.16 (Eclipse Adoptium)"
)
@Component
public class StockUpdateMapperImpl implements StockUpdateMapper {

    @Override
    public StockUpdateDTO toDto(Stock e) {
        if ( e == null ) {
            return null;
        }

        StockUpdateDTO.StockUpdateDTOBuilder stockUpdateDTO = StockUpdateDTO.builder();

        stockUpdateDTO.stockName( e.getStockName() );
        stockUpdateDTO.stockQuantity( e.getStockQuantity() );
        stockUpdateDTO.stockDescription( e.getStockDescription() );
        stockUpdateDTO.storage( e.getStorage() );

        return stockUpdateDTO.build();
    }

    @Override
    public Stock toEntity(StockUpdateDTO d) {
        if ( d == null ) {
            return null;
        }

        Stock.StockBuilder stock = Stock.builder();

        stock.stockName( d.getStockName() );
        stock.stockQuantity( d.getStockQuantity() );
        stock.stockDescription( d.getStockDescription() );
        stock.storage( d.getStorage() );

        return stock.build();
    }

    @Override
    public List<StockUpdateDTO> toDtoList(List<Stock> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StockUpdateDTO> list = new ArrayList<StockUpdateDTO>( entityList.size() );
        for ( Stock stock : entityList ) {
            list.add( toDto( stock ) );
        }

        return list;
    }

    @Override
    public List<Stock> toEntityList(List<StockUpdateDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Stock> list = new ArrayList<Stock>( dtoList.size() );
        for ( StockUpdateDTO stockUpdateDTO : dtoList ) {
            list.add( toEntity( stockUpdateDTO ) );
        }

        return list;
    }
}
