package com.onwelo.elections.dto;

import org.springframework.lang.NonNull;

public record UpdateElectorRequest(
        @NonNull
        Long id,
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @NonNull
        String documentNumber
) {
}
