package com.onwelo.elections.repository;

import com.onwelo.elections.model.CandidateElection;
import com.onwelo.elections.model.CandidateElectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateElectionRepository extends JpaRepository<CandidateElection, CandidateElectionId> {}
