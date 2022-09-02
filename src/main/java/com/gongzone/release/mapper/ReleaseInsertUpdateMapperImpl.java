package com.gongzone.release.mapper;

import com.gongzone.release.dto.ReleaseInsertUpdateDto;
import com.gongzone.release.entity.Release;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-31T23:16:36+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ReleaseInsertUpdateMapperImpl implements ReleaseInsertUpdateMapper {

    @Override
    public ReleaseInsertUpdateDto toDto(Release e) {
        if ( e == null ) {
            return null;
        }

        ReleaseInsertUpdateDto.ReleaseInsertUpdateDtoBuilder releaseInsertUpdateDto = ReleaseInsertUpdateDto.builder();

        releaseInsertUpdateDto.releaseId( e.getReleaseId() );
        releaseInsertUpdateDto.releaseDate( e.getReleaseDate() );
        releaseInsertUpdateDto.releaseDescription( e.getReleaseDescription() );
        releaseInsertUpdateDto.releaseQuantity( e.getReleaseQuantity() );
        releaseInsertUpdateDto.releaseTotalPrice( e.getReleaseTotalPrice() );
        releaseInsertUpdateDto.releaseType( e.getReleaseType() );
        releaseInsertUpdateDto.production( e.getProduction() );

        return releaseInsertUpdateDto.build();
    }

    @Override
    public List<ReleaseInsertUpdateDto> toDtoList(List<Release> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReleaseInsertUpdateDto> list = new ArrayList<ReleaseInsertUpdateDto>( entityList.size() );
        for ( Release release : entityList ) {
            list.add( toDto( release ) );
        }

        return list;
    }

    @Override
    public List<Release> toEntityList(List<ReleaseInsertUpdateDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Release> list = new ArrayList<Release>( dtoList.size() );
        for ( ReleaseInsertUpdateDto releaseInsertUpdateDto : dtoList ) {
            list.add( toEntity( releaseInsertUpdateDto ) );
        }

        return list;
    }
}
