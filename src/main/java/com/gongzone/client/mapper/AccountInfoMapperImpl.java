package com.gongzone.client.mapper;

import com.gongzone.client.dto.AccountInfoDto;
import com.gongzone.client.entity.ClientAccount;
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
public class AccountInfoMapperImpl implements AccountInfoMapper {

    @Override
    public AccountInfoDto toDto(ClientAccount e) {
        if ( e == null ) {
            return null;
        }

        AccountInfoDto.AccountInfoDtoBuilder accountInfoDto = AccountInfoDto.builder();

        accountInfoDto.accountId( e.getAccountId() );
        accountInfoDto.accountBank( e.getAccountBank() );
        accountInfoDto.accountNumber( e.getAccountNumber() );
        accountInfoDto.accountDepositor( e.getAccountDepositor() );

        return accountInfoDto.build();
    }

    @Override
    public ClientAccount toEntity(AccountInfoDto d) {
        if ( d == null ) {
            return null;
        }

        ClientAccount.ClientAccountBuilder clientAccount = ClientAccount.builder();

        clientAccount.accountId( d.getAccountId() );
        clientAccount.accountBank( d.getAccountBank() );
        clientAccount.accountNumber( d.getAccountNumber() );
        clientAccount.accountDepositor( d.getAccountDepositor() );

        return clientAccount.build();
    }

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
