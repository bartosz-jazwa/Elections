package com.onwelo.elections.repository;

import com.onwelo.elections.model.Elector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectorRepository extends JpaRepository<Elector, Long> {}
