package com.onwelo.elections.dto;

public record NewElectionResponse(
        Long id,
        String title,
        String date
) {
}
