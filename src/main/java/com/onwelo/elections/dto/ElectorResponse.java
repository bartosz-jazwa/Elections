package com.onwelo.elections.dto;

public record ElectorResponse(
        Long id,
        String firstName,
        String lastName,
        String documentNumber
) {
}
