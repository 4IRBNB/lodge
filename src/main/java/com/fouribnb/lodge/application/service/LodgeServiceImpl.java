package com.fouribnb.lodge.application.service;

import com.fouribnb.lodge.domain.entity.Lodge;
import com.fouribnb.lodge.domain.repository.LodgeRepository;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.request.UpdateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.UpdateLodgeResponseDto;
import com.fouribnb.lodge.presentation.mapper.LodgeMapper;
import com.fourirbnb.common.exception.ResourceNotFoundException;
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
        Lodge lodge = LodgeMapper.createToEntity(request);
        lodgeRepository.save(lodge);
        return LodgeMapper.CreateToResponse(lodge);
    }

    @Override
    public GetLodgeResponseDto getLodge(UUID id) {
        Lodge lodge = lodgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lodge를 찾을 수 없음"));
        return LodgeMapper.GetToResponse(lodge);
    }

    @Override
    public UpdateLodgeResponseDto updateLodge(UUID id, UpdateLodgeRequestDto request) {
        Lodge lodge = lodgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lodge를 찾을 수 없음"));
        lodge.update(request);
        return LodgeMapper.UpdateToResponse(lodge);
    }


}
