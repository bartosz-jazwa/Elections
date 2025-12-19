package com.onwelo.elections.service;

import com.onwelo.elections.dto.NewElectorRequest;
import com.onwelo.elections.dto.ElectorResponse;
import com.onwelo.elections.dto.UpdateElectorRequest;
import com.onwelo.elections.mapper.ElectorMapper;
import com.onwelo.elections.model.Elector;
import com.onwelo.elections.repository.ElectorRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElectorsService {
    private final ElectorRepository electorRepository;
    private final ElectorMapper mapper = Mappers.getMapper(ElectorMapper.class);

    public ElectorResponse addElector(NewElectorRequest request) {
        Elector saved = electorRepository.save(mapper.dtoToEntity(request));
        return mapper.entityToDto(saved);
    }

    public ElectorResponse updateElector(UpdateElectorRequest request) {
        return electorRepository.findById(request.id())
                .map(mapper::entityToDto)
                .orElse(null);
    }
}
