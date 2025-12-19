package com.onwelo.elections.dto;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

public record NewElectionRequest(
        @NonNull
        String title,
        @NonNull
        LocalDate date
) {
}
