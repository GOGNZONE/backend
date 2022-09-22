package com.gongzone.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
