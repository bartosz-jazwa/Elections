package com.onwelo.elections.dto;

import java.time.LocalDate;

public record NewElectionRequest(
        String title,
        LocalDate date
) {
}
