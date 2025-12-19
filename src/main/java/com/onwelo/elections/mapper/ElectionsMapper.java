package com.onwelo.elections.mapper;

import com.onwelo.elections.dto.ElectionWithCandidatesResponse;
import com.onwelo.elections.dto.NewElectionRequest;
import com.onwelo.elections.dto.NewElectionResponse;
import com.onwelo.elections.model.Election;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CandidateMapper.class)
public interface ElectionsMapper {
    Election requestToEntity(NewElectionRequest request);

    NewElectionResponse entityToResponse(Election entity);

    @Mapping(target = "candidates", source = "candidateElections")
    ElectionWithCandidatesResponse entityToResponseWithCandidates(Election entity);
}
