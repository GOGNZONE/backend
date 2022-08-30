package com.gongzone.stock.mapper;

import com.gongzone.stock.dto.StockListDTO;
import com.gongzone.stock.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-29T22:21:23+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class StockListMapperImpl implements StockListMapper {

    @Override
    public StockListDTO toDto(Stock e) {
        if ( e == null ) {
            return null;
        }

        StockListDTO.StockListDTOBuilder stockListDTO = StockListDTO.builder();

        stockListDTO.stockId( e.getStockId() );
        stockListDTO.stockName( e.getStockName() );
        stockListDTO.stockQuantity( e.getStockQuantity() );
        stockListDTO.stockDescription( e.getStockDescription() );

        return stockListDTO.build();
    }

    @Override
    public Stock toEntity(StockListDTO d) {
        if ( d == null ) {
            return null;
        }

        Stock.StockBuilder stock = Stock.builder();

        stock.stockId( d.getStockId() );
        stock.stockName( d.getStockName() );
        stock.stockQuantity( d.getStockQuantity() );
        stock.stockDescription( d.getStockDescription() );

        return stock.build();
    }

    @Override
    public List<StockListDTO> toDtoList(List<Stock> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StockListDTO> list = new ArrayList<StockListDTO>( entityList.size() );
        for ( Stock stock : entityList ) {
            list.add( toDto( stock ) );
        }

        return list;
    }

    @Override
    public List<Stock> toEntityList(List<StockListDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Stock> list = new ArrayList<Stock>( dtoList.size() );
        for ( StockListDTO stockListDTO : dtoList ) {
            list.add( toEntity( stockListDTO ) );
        }

        return list;
    }
}
