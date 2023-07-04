package com.sapiens.workshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sapiens.workshop.models.Proposal;


@Repository
public interface ProposalRepo  extends JpaRepository<Proposal,Integer> {
	@Query("SELECT proposals FROM Client c WHERE c.id = :id")
	 public List<Proposal> getProposalsByClientId(@Param("id") int id);
}
