package org.elections.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates_elections")
@Data
@NoArgsConstructor
public class CandidateElection {

    @EmbeddedId
    private CandidateElectionId id = new CandidateElectionId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId") // Mapuje część klucza do obiektu Candidate
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("electionId") // Mapuje część klucza do obiektu Election
    @JoinColumn(name = "election_id")
    private Election election;

    @Column(name = "votes")
    private Long votes;
}
