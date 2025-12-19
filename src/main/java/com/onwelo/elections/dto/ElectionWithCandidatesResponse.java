package com.onwelo.elections.dto;

import java.util.List;

public record ElectionWithCandidatesResponse(
        Long id,
        String title,
        String date,
        List<CandidateResponse> candidates
) {
}
