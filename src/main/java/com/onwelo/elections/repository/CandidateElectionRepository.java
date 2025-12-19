package com.onwelo.elections.repository;

import com.onwelo.elections.dto.CandidateWithVotesResponse;
import com.onwelo.elections.model.CandidateElection;
import com.onwelo.elections.model.CandidateElectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateElectionRepository extends JpaRepository<CandidateElection, CandidateElectionId> {
    @Modifying
    @Query("UPDATE CandidateElection ce SET ce.votes = ce.votes + 1 " +
            "WHERE ce.candidate.id = :candidateId AND ce.election.id = :electionId")
    int incrementVoteCount(@Param("candidateId") Long candidateId,
                           @Param("electionId") Long electionId);

    @Query("SELECT new com.onwelo.elections.dto.CandidateWithVotesResponse(" +
            "  CAST(ce.candidate.id AS long), " +
            "  ce.candidate.firstName, " +
            "  ce.candidate.lastName, " +
            "  ce.votes) " +
            "FROM CandidateElection ce " +
            "WHERE ce.election.id = :electionId " +
            "ORDER BY ce.votes DESC")
    List<CandidateWithVotesResponse> getResultsForElection(@Param("electionId") Long electionId);
}
