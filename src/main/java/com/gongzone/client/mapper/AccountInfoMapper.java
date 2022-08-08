package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.AccountInfoDto;
import com.gongzone.client.entity.ClientAccount;
import com.gongzone.common.mapper.GenericMapper;

/**
 * Client Account Information Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface AccountInfoMapper extends GenericMapper<AccountInfoDto, ClientAccount> {

	@Override
	default AccountInfoDto toDto(ClientAccount e) {
		 if ( e == null ) {
	            return null;
	        }

	        AccountInfoDto.AccountInfoDtoBuilder accountInfoDto = AccountInfoDto.builder();

	        accountInfoDto.accountId( e.getAccountId() );
	        accountInfoDto.accountBank( e.getAccountBank() );
	        accountInfoDto.accountNumber( e.getAccountNumber() );
	        accountInfoDto.accountDepositor( e.getAccountDepositor() );
	        accountInfoDto.client( e.getClient() );

	        return accountInfoDto.build();
	}
	
	@Override
	default ClientAccount toEntity(AccountInfoDto d) {
		  if ( d == null ) {
	            return null;
	        }

	        ClientAccount.ClientAccountBuilder clientAccount = ClientAccount.builder();

	        clientAccount.accountId( d.getAccountId() );
	        clientAccount.accountBank( d.getAccountBank() );
	        clientAccount.accountNumber( d.getAccountNumber() );
	        clientAccount.accountDepositor( d.getAccountDepositor() );
	        clientAccount.client( d.getClient() );

	        return clientAccount.build();
	}
}
