package com.onwelo.elections.service;

import com.onwelo.elections.dto.EligibleElectorInElection;
import com.onwelo.elections.dto.NewElectorRequest;
import com.onwelo.elections.dto.ElectorResponse;
import com.onwelo.elections.dto.UpdateElectorRequest;
import com.onwelo.elections.mapper.ElectorMapper;
import com.onwelo.elections.model.Elector;
import com.onwelo.elections.model.ElectorElection;
import com.onwelo.elections.model.ElectorElectionId;
import com.onwelo.elections.repository.ElectionRepository;
import com.onwelo.elections.repository.ElectorElectionRepository;
import com.onwelo.elections.repository.ElectorRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectorsService {
    private final ElectorRepository electorRepository;
    private final ElectionRepository electionRepository;
    private final ElectorElectionRepository electorElectionRepository;
    private final ElectorMapper mapper = Mappers.getMapper(ElectorMapper.class);

    @Transactional
    public ElectorResponse addElector(NewElectorRequest request) {
        Elector saved = electorRepository.save(mapper.dtoToEntity(request));
        electionRepository.findById(request.electionId()).ifPresent(election -> {
            ElectorElection electorElection = new ElectorElection(saved, election);
            electorElectionRepository.save(electorElection);
        });

        return mapper.entityToDto(saved);
    }

    public ElectorResponse updateElector(UpdateElectorRequest request) {
        return electorRepository.findById(request.id())
                .map(mapper::entityToDto)
                .orElse(null);
    }

    @Transactional
    public Optional<EligibleElectorInElection> blockElector(Long electorId, Long electionId) {
        electorElectionRepository.markBlockedForElectionsWithElector(electorId, electionId);
        return electorElectionRepository.findEligibleData(electorId, electionId);
    }
}
