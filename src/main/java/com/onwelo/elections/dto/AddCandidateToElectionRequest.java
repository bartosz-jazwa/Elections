package com.onwelo.elections.dto;

public record AddCandidateToElectionRequest(
        Long electionId,
        String candidateFirstName,
        String candidateLastName
) {
}
