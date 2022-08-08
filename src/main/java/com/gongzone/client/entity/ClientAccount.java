package com.gongzone.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 거래처 계좌 정보 엔티티
 * @author kimmingyu
 * @version 1.0 
 */
@Entity
@Table(name = "t_client_account")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientAccount {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_bank", length = 20)
	@NotNull(message = "bank must not be null")
	private String accountBank;
	
	@Column(name = "account_number", length = 30, unique = true)
	@NotNull(message = "account number must not be null")
	private String accountNumber;
	
	@Column(name = "account_depositor", length = 30)
	@NotNull(message = "depositor must not be null")
	private String accountDepositor;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	@NotNull(message = "client must not be null")
	@JsonIgnore
	private Client client;
	
	/**
	 * 거래처 계좌 정보 수정 메소드
	 * @param {accountBank, accountNumber, accountDepositor}
	 * @return void
	 * @author kimmingyu
	 * @version 1.0
	 */
	
	public void updateClientAccount(String accountBank, String accountNumber, String accountDepositor) {
		this.accountBank = accountBank;
		this.accountNumber = accountNumber;
		this.accountDepositor = accountDepositor;
	}
}
