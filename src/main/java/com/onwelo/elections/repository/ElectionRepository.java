package com.onwelo.elections.repository;

import com.onwelo.elections.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {

    @Query("SELECT e FROM Election e " +
            "LEFT JOIN FETCH e.candidateElections ce " +
            "LEFT JOIN FETCH ce.candidate " +
            "WHERE e.id = :electionId")
    Optional<Election> findByIdWithCandidates(@Param("electionId") Long electionId);
}
