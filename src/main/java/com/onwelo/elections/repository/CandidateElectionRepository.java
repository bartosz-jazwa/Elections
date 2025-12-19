package org.elections.repository;

import org.elections.model.CandidateElection;
import org.elections.model.CandidateElectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateElectionRepository extends JpaRepository<CandidateElection, CandidateElectionId> {}
