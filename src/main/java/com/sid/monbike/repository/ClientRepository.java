package com.sid.monbike.repository;

import com.sid.monbike.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findClientByTel(String email);
}
