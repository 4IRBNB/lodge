package com.fouribnb.lodge.application.service;

import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import java.util.UUID;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;


public interface LodgeService {

    CreateLodgeResponseDto createLodge(CreateLodgeRequestDto request);

    GetLodgeResponseDto getLodge(UUID id) throws NotFoundException;
}
