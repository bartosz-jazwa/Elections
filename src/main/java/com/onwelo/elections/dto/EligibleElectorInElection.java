package com.onwelo.elections.dto;

import java.time.LocalDate;

public record EligibleElectorInElection(
        Long electionId,
        String electionTitle,
        LocalDate electionDate,
        Long electorId,
        String electorFirstName,
        String electorLastName,
        Boolean isEligible
) {
}
