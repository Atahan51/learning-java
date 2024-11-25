package com.esalink.dokuman_servisi.repository;

import com.esalink.dokuman_servisi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNameAndPassword(String name, String password);
}
