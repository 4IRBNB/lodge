package com.fouribnb.lodge.application.service;

import com.fouribnb.lodge.domain.entity.Lodge;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.request.UpdateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.UpdateLodgeResponseDto;
import java.util.List;
import java.util.UUID;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LodgeService {

    CreateLodgeResponseDto createLodge(CreateLodgeRequestDto request);

    GetLodgeResponseDto getLodge(UUID id);

    UpdateLodgeResponseDto updateLodge(UUID id, UpdateLodgeRequestDto request);

    Page<GetLodgeResponseDto> getLodges(Pageable pageable);

}
