package com.gongzone.release.mapper;

import com.gongzone.release.dto.ReleaseDetailsDto;
import com.gongzone.release.entity.Release;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T05:28:36+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ReleaseDetailsMapperImpl implements ReleaseDetailsMapper {

    @Override
    public Release toEntity(ReleaseDetailsDto d) {
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
    public List<ReleaseDetailsDto> toDtoList(List<Release> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReleaseDetailsDto> list = new ArrayList<ReleaseDetailsDto>( entityList.size() );
        for ( Release release : entityList ) {
            list.add( toDto( release ) );
        }

        return list;
    }

    @Override
    public List<Release> toEntityList(List<ReleaseDetailsDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Release> list = new ArrayList<Release>( dtoList.size() );
        for ( ReleaseDetailsDto releaseDetailsDto : dtoList ) {
            list.add( toEntity( releaseDetailsDto ) );
        }

        return list;
    }
}
