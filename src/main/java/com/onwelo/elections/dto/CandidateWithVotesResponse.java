package com.onwelo.elections.dto;

public record CandidateWithVotesResponse(
        Long id,
        String firstName,
        String lastName,
        Long votes
) {
}
