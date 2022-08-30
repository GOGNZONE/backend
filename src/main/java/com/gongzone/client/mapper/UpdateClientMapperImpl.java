package com.gongzone.client.mapper;

import com.gongzone.client.dto.UpdateClientDto;
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
public class UpdateClientMapperImpl implements UpdateClientMapper {

    @Override
    public UpdateClientDto toDto(Client e) {
        if ( e == null ) {
            return null;
        }

        UpdateClientDto.UpdateClientDtoBuilder updateClientDto = UpdateClientDto.builder();

        updateClientDto.clientName( e.getClientName() );
        updateClientDto.clientTel( e.getClientTel() );
        updateClientDto.clientAddress( e.getClientAddress() );
        updateClientDto.clientFile( e.getClientFile() );
        updateClientDto.clientManager( e.getClientManager() );

        return updateClientDto.build();
    }

    @Override
    public Client toEntity(UpdateClientDto d) {
        if ( d == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.clientName( d.getClientName() );
        client.clientManager( d.getClientManager() );
        client.clientTel( d.getClientTel() );
        client.clientAddress( d.getClientAddress() );
        client.clientFile( d.getClientFile() );

        return client.build();
    }

    @Override
    public List<UpdateClientDto> toDtoList(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UpdateClientDto> list = new ArrayList<UpdateClientDto>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<UpdateClientDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( UpdateClientDto updateClientDto : dtoList ) {
            list.add( toEntity( updateClientDto ) );
        }

        return list;
    }
}
