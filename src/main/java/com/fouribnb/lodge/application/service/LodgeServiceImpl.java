package com.fouribnb.lodge.application.service;

import com.fouribnb.lodge.config.LodgeErrorCode;
import com.fouribnb.lodge.domain.entity.Lodge;
import com.fouribnb.lodge.domain.repository.LodgeRepository;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fouribnb.lodge.presentation.mapper.LodgeMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LodgeServiceImpl implements LodgeService {
    private final LodgeRepository lodgeRepository;

    @Override
    public CreateLodgeResponseDto createLodge(CreateLodgeRequestDto request) {
        Lodge lodge = LodgeMapper.CreateLodgeRequestDtoToEntity(request);
        lodgeRepository.save(lodge);
        return LodgeMapper.EntityToCreateLodgeRequestDto(lodge);
    }

    @Override
    public GetLodgeResponseDto getLodge(UUID id) throws NotFoundException {
        Lodge lodge = lodgeRepository.findById(id).orElseThrow(() -> new NotFoundException());
        //todo. customException?
        return LodgeMapper.EntityToGetLodgeRequestDto(lodge);
    }
}
