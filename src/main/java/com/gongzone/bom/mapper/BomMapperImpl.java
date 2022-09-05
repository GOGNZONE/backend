package com.gongzone.bom.mapper;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
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
public class BomMapperImpl implements BomMapper {

    @Override
    public BOMDTO toDto(BOM e) {
        if ( e == null ) {
            return null;
        }

        BOMDTO.BOMDTOBuilder bOMDTO = BOMDTO.builder();

        bOMDTO.bomId( e.getBomId() );
        bOMDTO.bomName( e.getBomName() );
        bOMDTO.bomQuantity( e.getBomQuantity() );
        bOMDTO.bomPrice( e.getBomPrice() );
        bOMDTO.bomStandard( e.getBomStandard() );
        bOMDTO.bomUnit( e.getBomUnit() );
        bOMDTO.bomDescription( e.getBomDescription() );
        bOMDTO.bomReceivedData( e.getBomReceivedData() );
        bOMDTO.bomFile( e.getBomFile() );
        bOMDTO.bomRequiredQuntity( e.getBomRequiredQuntity() );
        bOMDTO.storage( e.getStorage() );
        bOMDTO.bomParent( e.getBomParent() );

        return bOMDTO.build();
    }

    @Override
    public BOM toEntity(BOMDTO d) {
        if ( d == null ) {
            return null;
        }

        BOM.BOMBuilder bOM = BOM.builder();

        bOM.bomId( d.getBomId() );
        bOM.bomName( d.getBomName() );
        bOM.bomQuantity( d.getBomQuantity() );
        bOM.bomPrice( d.getBomPrice() );
        bOM.bomStandard( d.getBomStandard() );
        bOM.bomUnit( d.getBomUnit() );
        bOM.bomDescription( d.getBomDescription() );
        bOM.bomReceivedData( d.getBomReceivedData() );
        bOM.bomFile( d.getBomFile() );
        bOM.bomRequiredQuntity( d.getBomRequiredQuntity() );
        bOM.storage( d.getStorage() );
        bOM.bomParent( d.getBomParent() );

        return bOM.build();
    }

    @Override
    public List<BOMDTO> toDtoList(List<BOM> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BOMDTO> list = new ArrayList<BOMDTO>( entityList.size() );
        for ( BOM bOM : entityList ) {
            list.add( toDto( bOM ) );
        }

        return list;
    }

    @Override
    public List<BOM> toEntityList(List<BOMDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BOM> list = new ArrayList<BOM>( dtoList.size() );
        for ( BOMDTO bOMDTO : dtoList ) {
            list.add( toEntity( bOMDTO ) );
        }

        return list;
    }
}
