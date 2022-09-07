package com.gongzone.client.mapper;

import com.gongzone.client.dto.AccountInfoDto;
import com.gongzone.entity.client.ClientAccount;

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
public class AccountInfoMapperImpl implements AccountInfoMapper {

    @Override
    public List<AccountInfoDto> toDtoList(List<ClientAccount> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AccountInfoDto> list = new ArrayList<AccountInfoDto>( entityList.size() );
        for ( ClientAccount clientAccount : entityList ) {
            list.add( toDto( clientAccount ) );
        }

        return list;
    }

    @Override
    public List<ClientAccount> toEntityList(List<AccountInfoDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ClientAccount> list = new ArrayList<ClientAccount>( dtoList.size() );
        for ( AccountInfoDto accountInfoDto : dtoList ) {
            list.add( toEntity( accountInfoDto ) );
        }

        return list;
    }
}
