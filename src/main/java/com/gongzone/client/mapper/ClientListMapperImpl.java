package com.gongzone.client.mapper;

import com.gongzone.client.dto.ClientListDto;
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
public class ClientListMapperImpl implements ClientListMapper {

    @Override
    public ClientListDto toDto(Client e) {
        if ( e == null ) {
            return null;
        }

        ClientListDto.ClientListDtoBuilder clientListDto = ClientListDto.builder();

        clientListDto.clientId( e.getClientId() );
        clientListDto.clientName( e.getClientName() );
        clientListDto.clientAddress( e.getClientAddress() );
        clientListDto.clientManager( e.getClientManager() );
        clientListDto.clientTel( e.getClientTel() );
        clientListDto.clientRegisteredDate( e.getClientRegisteredDate() );

        return clientListDto.build();
    }

    @Override
    public Client toEntity(ClientListDto d) {
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

        return client.build();
    }

    @Override
    public List<ClientListDto> toDtoList(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClientListDto> list = new ArrayList<ClientListDto>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<ClientListDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ClientListDto clientListDto : dtoList ) {
            list.add( toEntity( clientListDto ) );
        }

        return list;
    }
}
