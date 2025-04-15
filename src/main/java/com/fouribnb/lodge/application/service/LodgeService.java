package com.fouribnb.lodge.application.service;

import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;


public interface LodgeService {

    CreateLodgeResponseDto createLodge(CreateLodgeRequestDto request);

}
