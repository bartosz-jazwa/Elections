package com.onwelo.elections.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateElectionId implements Serializable {
    private Long candidateId;
    private Long electionId;
}
