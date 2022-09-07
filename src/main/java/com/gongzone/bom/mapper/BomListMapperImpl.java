package com.gongzone.bom.mapper;

import com.gongzone.bom.dto.BOMListDTO;
import com.gongzone.entity.bom.BOM;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T18:19:55+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class BomListMapperImpl implements BomListMapper {

    @Override
    public BOMListDTO toDto(BOM e) {
        if ( e == null ) {
            return null;
        }

        BOMListDTO.BOMListDTOBuilder bOMListDTO = BOMListDTO.builder();

        bOMListDTO.bomId( e.getBomId() );
        bOMListDTO.bomName( e.getBomName() );
        bOMListDTO.bomQuantity( e.getBomQuantity() );
        bOMListDTO.bomDescription( e.getBomDescription() );
        bOMListDTO.bomPrice(e.getBomPrice());


        return bOMListDTO.build();
    }

    @Override
    public BOM toEntity(BOMListDTO d) {
        if ( d == null ) {
            return null;
        }

        BOM.BOMBuilder bOM = BOM.builder();

        bOM.bomId( d.getBomId() );
        bOM.bomName( d.getBomName() );
        bOM.bomQuantity( d.getBomQuantity() );
        bOM.bomDescription( d.getBomDescription() );
        bOM.bomPrice( d.getBomPrice());

        return bOM.build();
    }

    @Override
    public List<BOMListDTO> toDtoList(List<BOM> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BOMListDTO> list = new ArrayList<BOMListDTO>( entityList.size() );
        for ( BOM bOM : entityList ) {
            list.add( toDto( bOM ) );
        }

        return list;
    }

    @Override
    public List<BOM> toEntityList(List<BOMListDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BOM> list = new ArrayList<BOM>( dtoList.size() );
        for ( BOMListDTO bOMListDTO : dtoList ) {
            list.add( toEntity( bOMListDTO ) );
        }

        return list;
    }
}
