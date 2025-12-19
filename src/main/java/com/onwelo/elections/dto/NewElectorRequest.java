package com.onwelo.elections.dto;

import org.springframework.lang.NonNull;

public record NewElectorRequest(
        @NonNull
        Long electionId,
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @NonNull
        String documentNumber
) {
}
