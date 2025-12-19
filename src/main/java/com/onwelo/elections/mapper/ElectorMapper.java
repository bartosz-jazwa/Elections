package com.onwelo.elections.mapper;

import com.onwelo.elections.dto.NewElectorRequest;
import com.onwelo.elections.dto.ElectorResponse;
import com.onwelo.elections.model.Elector;
import org.mapstruct.Mapper;

@Mapper
public interface ElectorMapper {

    Elector dtoToEntity(NewElectorRequest request);

    ElectorResponse entityToDto(Elector entity);
}
