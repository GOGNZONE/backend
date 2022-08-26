package com.gongzone.stock.mapper;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T15:58:16+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class StockMapperImpl implements StockMapper {

    @Override
    public StockDTO toDto(Stock e) {
        if ( e == null ) {
            return null;
        }

        StockDTO.StockDTOBuilder stockDTO = StockDTO.builder();

        stockDTO.stockId( e.getStockId() );
        stockDTO.stockName( e.getStockName() );
        stockDTO.stockQuantity( e.getStockQuantity() );
        stockDTO.stockDescription( e.getStockDescription() );
        stockDTO.storage( e.getStorage() );

        return stockDTO.build();
    }

    @Override
    public Stock toEntity(StockDTO d) {
        if ( d == null ) {
            return null;
        }

        Stock.StockBuilder stock = Stock.builder();

        stock.stockId( d.getStockId() );
        stock.stockName( d.getStockName() );
        stock.stockQuantity( d.getStockQuantity() );
        stock.stockDescription( d.getStockDescription() );
        stock.storage( d.getStorage() );

        return stock.build();
    }

    @Override
    public List<StockDTO> toDtoList(List<Stock> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StockDTO> list = new ArrayList<StockDTO>( entityList.size() );
        for ( Stock stock : entityList ) {
            list.add( toDto( stock ) );
        }

        return list;
    }

    @Override
    public List<Stock> toEntityList(List<StockDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Stock> list = new ArrayList<Stock>( dtoList.size() );
        for ( StockDTO stockDTO : dtoList ) {
            list.add( toEntity( stockDTO ) );
        }

        return list;
    }
}
