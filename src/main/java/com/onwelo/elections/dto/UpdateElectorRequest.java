package com.onwelo.elections.dto;

public record UpdateElectorRequest(
        Long id,
        String firstName,
        String lastName,
        String documentNumber
) {
}
