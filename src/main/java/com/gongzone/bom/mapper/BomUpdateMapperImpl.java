package com.gongzone.bom.mapper;

import com.gongzone.bom.dto.BOMUpdateDTO;
import com.gongzone.bom.entity.BOM;
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
public class BomUpdateMapperImpl implements BomUpdateMapper {

    @Override
    public BOMUpdateDTO toDto(BOM e) {
        if ( e == null ) {
            return null;
        }

        BOMUpdateDTO.BOMUpdateDTOBuilder bOMUpdateDTO = BOMUpdateDTO.builder();

        bOMUpdateDTO.bomName( e.getBomName() );
        bOMUpdateDTO.bomQuantity( e.getBomQuantity() );
        bOMUpdateDTO.bomPrice( e.getBomPrice() );
        bOMUpdateDTO.bomStandard( e.getBomStandard() );
        bOMUpdateDTO.bomUnit( e.getBomUnit() );
        bOMUpdateDTO.bomDescription( e.getBomDescription() );
        bOMUpdateDTO.bomFile( e.getBomFile() );
        bOMUpdateDTO.bomRequiredQuntity( e.getBomRequiredQuntity() );

        return bOMUpdateDTO.build();
    }

    @Override
    public BOM toEntity(BOMUpdateDTO d) {
        if ( d == null ) {
            return null;
        }

        BOM.BOMBuilder bOM = BOM.builder();

        bOM.bomName( d.getBomName() );
        bOM.bomQuantity( d.getBomQuantity() );
        bOM.bomPrice( d.getBomPrice() );
        bOM.bomStandard( d.getBomStandard() );
        bOM.bomUnit( d.getBomUnit() );
        bOM.bomDescription( d.getBomDescription() );
        bOM.bomFile( d.getBomFile() );
        bOM.bomRequiredQuntity( d.getBomRequiredQuntity() );

        return bOM.build();
    }

    @Override
    public List<BOMUpdateDTO> toDtoList(List<BOM> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BOMUpdateDTO> list = new ArrayList<BOMUpdateDTO>( entityList.size() );
        for ( BOM bOM : entityList ) {
            list.add( toDto( bOM ) );
        }

        return list;
    }

    @Override
    public List<BOM> toEntityList(List<BOMUpdateDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BOM> list = new ArrayList<BOM>( dtoList.size() );
        for ( BOMUpdateDTO bOMUpdateDTO : dtoList ) {
            list.add( toEntity( bOMUpdateDTO ) );
        }

        return list;
    }
}
