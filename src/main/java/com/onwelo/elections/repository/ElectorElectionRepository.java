package com.onwelo.elections.repository;

import com.onwelo.elections.model.ElectorElection;
import com.onwelo.elections.model.ElectorElectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectorElectionRepository extends JpaRepository<ElectorElection, ElectorElectionId> {}
