package com.onwelo.elections.dto;

public record AddElectorRequest(
        String firstName,
        String lastName,
        String documentNumber
) {
}
