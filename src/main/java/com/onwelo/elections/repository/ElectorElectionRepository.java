package org.elections.repository;

import org.elections.model.ElectorElection;
import org.elections.model.ElectorElectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectorElectionRepository extends JpaRepository<ElectorElection, ElectorElectionId> {}
