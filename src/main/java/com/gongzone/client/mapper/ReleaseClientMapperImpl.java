package com.gongzone.client.mapper;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.client.entity.Client;
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
public class ReleaseClientMapperImpl implements ReleaseClientMapper {

    @Override
    public Client toEntity(ReleaseClientDto d) {
        if ( d == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.clientId( d.getClientId() );
        client.clientName( d.getClientName() );
        client.clientManager( d.getClientManager() );
        client.clientTel( d.getClientTel() );
        client.clientAddress( d.getClientAddress() );

        return client.build();
    }

    @Override
    public List<ReleaseClientDto> toDtoList(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReleaseClientDto> list = new ArrayList<ReleaseClientDto>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<ReleaseClientDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ReleaseClientDto releaseClientDto : dtoList ) {
            list.add( toEntity( releaseClientDto ) );
        }

        return list;
    }
}
