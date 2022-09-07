package com.gongzone.client.mapper;

import com.gongzone.client.dto.AccountDto;
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
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDto(ClientAccount e) {
        if ( e == null ) {
            return null;
        }

        AccountDto.AccountDtoBuilder accountDto = AccountDto.builder();

        accountDto.accountId( e.getAccountId() );
        accountDto.accountBank( e.getAccountBank() );
        accountDto.accountNumber( e.getAccountNumber() );
        accountDto.accountDepositor( e.getAccountDepositor() );

        return accountDto.build();
    }

    @Override
    public ClientAccount toEntity(AccountDto d) {
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
    public List<AccountDto> toDtoList(List<ClientAccount> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( entityList.size() );
        for ( ClientAccount clientAccount : entityList ) {
            list.add( toDto( clientAccount ) );
        }

        return list;
    }

    @Override
    public List<ClientAccount> toEntityList(List<AccountDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ClientAccount> list = new ArrayList<ClientAccount>( dtoList.size() );
        for ( AccountDto accountDto : dtoList ) {
            list.add( toEntity( accountDto ) );
        }

        return list;
    }
}
