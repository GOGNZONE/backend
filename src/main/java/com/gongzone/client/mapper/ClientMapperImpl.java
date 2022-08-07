package com.gongzone.client.mapper;

import com.gongzone.client.dto.ClientDto;
import com.gongzone.client.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T17:11:18+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client e) {
        if ( e == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.clientName( e.getClientName() );
        clientDto.clientManager( e.getClientManager() );
        clientDto.clientTel( e.getClientTel() );
        clientDto.clientAddress( e.getClientAddress() );
        clientDto.clientFile( e.getClientFile() );
        clientDto.employee( e.getEmployee() );

        return clientDto.build();
    }

    @Override
    public Client toEntity(ClientDto d) {
        if ( d == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.clientName( d.getClientName() );
        client.clientManager( d.getClientManager() );
        client.clientTel( d.getClientTel() );
        client.clientAddress( d.getClientAddress() );
        client.clientFile( d.getClientFile() );
        client.employee( d.getEmployee() );

        return client.build();
    }

    @Override
    public List<ClientDto> toDtoList(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<ClientDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ClientDto clientDto : dtoList ) {
            list.add( toEntity( clientDto ) );
        }

        return list;
    }
}
