package com.onwelo.elections.mapper;

import com.onwelo.elections.dto.AddCandidateToElectionRequest;
import com.onwelo.elections.dto.CandidateResponse;
import com.onwelo.elections.model.Candidate;
import com.onwelo.elections.model.CandidateElection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CandidateMapper {

    @Mapping(target = "firstName", source = "candidateFirstName")
    @Mapping(target = "lastName", source = "candidateLastName")
    Candidate requestToEntity(AddCandidateToElectionRequest request);

    CandidateResponse entityToResponse(Candidate candidate);

    @Mapping(target = ".", source = "candidate")
    CandidateResponse joiningEntityToResponse(CandidateElection candidateElection);
}
