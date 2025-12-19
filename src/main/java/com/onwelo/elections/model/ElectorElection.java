package org.elections.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "electors_elections")
@Data
@NoArgsConstructor
public class ElectorElection {

    @EmbeddedId
    private ElectorElectionId id = new ElectorElectionId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("electorId")
    @JoinColumn(name = "elector_id")
    private Elector elector;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("electionId")
    @JoinColumn(name = "election_id")
    private Election election;

    @Column(name = "candidate_voted")
    private Boolean candidateVoted;

    @Column(name = "candidate_blocked")
    private Boolean candidateBlocked;
}
