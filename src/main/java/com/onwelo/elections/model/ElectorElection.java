package com.onwelo.elections.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Elector elector;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("electionId")
    @JoinColumn(name = "election_id")
    @JsonBackReference
    private Election election;

    @Column(name = "elector_voted")
    private Boolean electorVoted;

    @Column(name = "elector_blocked")
    private Boolean electorBlocked;

    public ElectorElection(Elector elector, Election election) {
        this.elector = elector;
        this.election = election;
        this.electorVoted = false;
        this.electorBlocked = false;
    }
}
