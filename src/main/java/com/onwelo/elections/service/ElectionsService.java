package com.onwelo.elections.service;

import com.onwelo.elections.dto.AddCandidateToElectionRequest;
import com.onwelo.elections.dto.CandidateWithVotesResponse;
import com.onwelo.elections.dto.ElectionWithCandidatesResponse;
import com.onwelo.elections.dto.NewElectionRequest;
import com.onwelo.elections.dto.NewElectionResponse;
import com.onwelo.elections.dto.VoteRequest;
import com.onwelo.elections.mapper.CandidateMapper;
import com.onwelo.elections.mapper.ElectionsMapper;
import com.onwelo.elections.model.Candidate;
import com.onwelo.elections.model.CandidateElection;
import com.onwelo.elections.model.CandidateElectionId;
import com.onwelo.elections.model.Election;
import com.onwelo.elections.repository.CandidateElectionRepository;
import com.onwelo.elections.repository.CandidateRepository;
import com.onwelo.elections.repository.ElectionRepository;
import com.onwelo.elections.repository.ElectorElectionRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectionsService {
    private final ElectionRepository electionRepository;
    private final CandidateRepository candidateRepository;
    private final CandidateElectionRepository candidateElectionRepository;
    private final ElectorElectionRepository electorElectionRepository;

    private final ElectionsMapper electionsMapper = Mappers.getMapper(ElectionsMapper.class);
    private final CandidateMapper candidateMapper = Mappers.getMapper(CandidateMapper.class);

    public NewElectionResponse createNewElection(NewElectionRequest request) {
        Election saved = electionRepository.save(electionsMapper.requestToEntity(request));
        return electionsMapper.entityToResponse(saved);
    }

    @Transactional
    public ElectionWithCandidatesResponse addCandidateToElection(AddCandidateToElectionRequest request) {
        electionRepository.findById(request.electionId()).ifPresent(election -> {
            Candidate candidate = candidateRepository.save(candidateMapper.requestToEntity(request));

            candidateElectionRepository.save(new CandidateElection(candidate, election));
        });
        return electionRepository.findByIdWithCandidates(request.electionId())
                .map(electionsMapper::entityToResponseWithCandidates).orElse(null);
    }

    public ElectionWithCandidatesResponse removeCandidateFromElection(Long electionId, Long candidateId) {
        CandidateElectionId candidateElectionId = new CandidateElectionId(candidateId, electionId);
        candidateElectionRepository.deleteById(candidateElectionId);
        return electionRepository.findByIdWithCandidates(electionId)
                .map(electionsMapper::entityToResponseWithCandidates).orElse(null);
    }

    public List<ElectionWithCandidatesResponse> getAllElectionsWithCandidates() {
        return electionRepository.findAll().stream()
                .map(electionsMapper::entityToResponseWithCandidates)
                .toList();
    }

    public Optional<ElectionWithCandidatesResponse> getElectionWithCandidates(Long electionId) {
        return electionRepository.findByIdWithCandidates(electionId)
                .map(electionsMapper::entityToResponseWithCandidates);
    }

    @Transactional
    public List<CandidateWithVotesResponse> vote(VoteRequest request) {
        electorElectionRepository.markVotedForElectionsWithElector(request.electorId(), request.electionId());
        candidateElectionRepository.incrementVoteCount(request.candidateId(),  request.electionId());
        return candidateElectionRepository.getResultsForElection(request.electionId());
    }
}
