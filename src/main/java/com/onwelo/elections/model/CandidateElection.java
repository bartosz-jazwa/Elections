package com.onwelo.elections.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @MapsId("candidateId")
    @JoinColumn(name = "candidate_id")
    @JsonBackReference
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("electionId")
    @JoinColumn(name = "election_id")
    @JsonBackReference
    private Election election;

    @Column(name = "votes")
    private Long votes;

    public CandidateElection(Candidate candidate, Election election) {
        this.candidate = candidate;
        this.election = election;
    }
}
