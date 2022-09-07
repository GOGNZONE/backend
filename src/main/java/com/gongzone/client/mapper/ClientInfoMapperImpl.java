package com.gongzone.client.mapper;

import com.gongzone.client.dto.ClientInfoDto;
import com.gongzone.entity.client.Client;

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
public class ClientInfoMapperImpl implements ClientInfoMapper {

    @Override
    public Client toEntity(ClientInfoDto d) {
        if ( d == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.clientId( d.getClientId() );
        client.clientName( d.getClientName() );
        client.clientManager( d.getClientManager() );
        client.clientTel( d.getClientTel() );
        client.clientAddress( d.getClientAddress() );
        client.clientRegisteredDate( d.getClientRegisteredDate() );
        client.clientFile( d.getClientFile() );

        return client.build();
    }

    @Override
    public List<ClientInfoDto> toDtoList(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClientInfoDto> list = new ArrayList<ClientInfoDto>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<ClientInfoDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ClientInfoDto clientInfoDto : dtoList ) {
            list.add( toEntity( clientInfoDto ) );
        }

        return list;
    }
}
