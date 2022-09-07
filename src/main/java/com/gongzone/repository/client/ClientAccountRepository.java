package com.gongzone.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.client.ClientAccount;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

}
