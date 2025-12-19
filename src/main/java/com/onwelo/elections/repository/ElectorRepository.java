package org.elections.repository;

import org.elections.model.Elector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectorRepository extends JpaRepository<Elector, Integer> {}
