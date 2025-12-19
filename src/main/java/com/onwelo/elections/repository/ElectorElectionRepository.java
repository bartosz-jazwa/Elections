package com.onwelo.elections.repository;

import com.onwelo.elections.dto.EligibleElectorInElection;
import com.onwelo.elections.model.ElectorElection;
import com.onwelo.elections.model.ElectorElectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectorElectionRepository extends JpaRepository<ElectorElection, ElectorElectionId> {

    @Modifying
    @Query("UPDATE ElectorElection ee SET ee.electorBlocked = true " +
            "WHERE ee.id.electorId = :electorId AND ee.id.electionId = :electionId")
    int markBlockedForElectionsWithElector(@Param("electorId") Long electorId, @Param("electionId") Long electionId);

    @Query("SELECT new com.onwelo.elections.dto.EligibleElectorInElection(" +
            "  CAST(e.id AS long), " +
            "  e.title, " +
            "  e.date, " +
            "  CAST(el.id AS long), " +
            "  el.firstName, " +
            "  el.lastName, " +
            "  (CASE WHEN ee.electorBlocked = true THEN false ELSE true END)) " +
            "FROM ElectorElection ee " +
            "JOIN ee.election e " +
            "JOIN ee.elector el " +
            "WHERE el.id = :electorId AND e.id = :electionId")
    Optional<EligibleElectorInElection> findEligibleData(@Param("electorId") Long electorId, @Param("electionId") Long electionId);

    @Modifying
    @Query("UPDATE ElectorElection ee SET ee.electorVoted = true " +
            "WHERE ee.id.electorId = :electorId AND ee.id.electionId = :electionId AND ee.electorVoted = false AND ee.electorBlocked = false")
    int markVotedForElectionsWithElector(@Param("electorId") Long electorId, @Param("electionId") Long electionId);
}
