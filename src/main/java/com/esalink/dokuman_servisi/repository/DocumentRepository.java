package com.esalink.dokuman_servisi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esalink.dokuman_servisi.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("SELECT d FROM Document d JOIN FETCH d.client")
    List<Document> getAllWithClients();

    @Query("SELECT d FROM Document d WHERE d.client.id = :clientId")
    List<Document> findAllByClientId(@Param("clientId") Long clientId);

}