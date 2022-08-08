package com.gongzone.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.client.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}