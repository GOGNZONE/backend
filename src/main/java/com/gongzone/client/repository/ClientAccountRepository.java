package com.gongzone.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.client.entity.ClientAccount;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

}
