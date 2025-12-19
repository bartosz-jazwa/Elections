package com.onwelo.elections.dto;

public record NewElectorRequest(
        String firstName,
        String lastName,
        String documentNumber
) {
}
