package com.onwelo.elections.controller;

import com.onwelo.elections.dto.AddCandidateToElectionRequest;
import com.onwelo.elections.dto.ElectionWithCandidatesResponse;
import com.onwelo.elections.dto.NewElectionRequest;
import com.onwelo.elections.dto.NewElectionResponse;
import com.onwelo.elections.service.ElectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elections")
@RequiredArgsConstructor
class ElectionsController {
    private final ElectionsService electionsService;

    @PostMapping
    NewElectionResponse createNewElections(@RequestBody NewElectionRequest request) {
        return electionsService.createNewElection(request);
    }

    @PutMapping
    ElectionWithCandidatesResponse addCandidate(@RequestBody AddCandidateToElectionRequest request) {
        return electionsService.addCandidateToElection(request);
    }

    @PatchMapping
    ElectionWithCandidatesResponse removeCandidateFromElection(@RequestParam Long electionId, @RequestParam Long candidateId) {
        return electionsService.removeCandidateFromElection(electionId, candidateId);
    }
}
