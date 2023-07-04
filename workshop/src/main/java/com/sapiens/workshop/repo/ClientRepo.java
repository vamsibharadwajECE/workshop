package com.sapiens.workshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sapiens.workshop.models.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
    @Query("SELECT c FROM Client c WHERE c.clientname = :clientname")
    public Client getClientByClientname(@Param("clientname") String clientname);
}
