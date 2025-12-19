package com.onwelo.elections.dto;

import org.springframework.lang.NonNull;

public record VoteRequest(
        @NonNull
        Long electionId,
        @NonNull
        Long candidateId,
        @NonNull
        Long electorId
) {
}
