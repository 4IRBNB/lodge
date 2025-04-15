package com.fouribnb.lodge.application.service;

import com.fouribnb.lodge.domain.entity.Lodge;
import com.fouribnb.lodge.domain.repository.LodgeRepository;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.mapper.LodgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LodgeServiceImpl implements LodgeService {
    private final LodgeRepository lodgeRepository;

    @Override
    public CreateLodgeResponseDto createLodge(CreateLodgeRequestDto request) {
        Lodge lodge = LodgeMapper.CreateLodgeRequestDtoToEntity(request);
        lodgeRepository.save(lodge);
        return LodgeMapper.EntityToCreateLodgeRequestDto(lodge);
    }
}
