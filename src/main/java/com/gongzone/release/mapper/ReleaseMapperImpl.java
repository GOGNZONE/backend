package com.gongzone.release.mapper;

import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.entity.Release;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-06T13:11:18+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ReleaseMapperImpl implements ReleaseMapper {

    @Override
    public Release toEntity(ReleaseDto d) {
        if ( d == null ) {
            return null;
        }

        Release.ReleaseBuilder release = Release.builder();

        release.releaseId( d.getReleaseId() );
        release.releaseDate( d.getReleaseDate() );
        release.releaseDescription( d.getReleaseDescription() );
        release.releaseQuantity( d.getReleaseQuantity() );
        release.releaseTotalPrice( d.getReleaseTotalPrice() );
        release.releaseType( d.getReleaseType() );

        return release.build();
    }

    @Override
    public List<ReleaseDto> toDtoList(List<Release> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReleaseDto> list = new ArrayList<ReleaseDto>( entityList.size() );
        for ( Release release : entityList ) {
            list.add( toDto( release ) );
        }

        return list;
    }

    @Override
    public List<Release> toEntityList(List<ReleaseDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Release> list = new ArrayList<Release>( dtoList.size() );
        for ( ReleaseDto releaseDto : dtoList ) {
            list.add( toEntity( releaseDto ) );
        }

        return list;
    }
}
