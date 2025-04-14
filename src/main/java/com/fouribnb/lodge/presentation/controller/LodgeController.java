package com.fouribnb.lodge.presentation.controller;

import com.fouribnb.lodge.application.service.LodgeService;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lodges")
public class LodgeController {

    private final LodgeService lodgeService;

    //객실생성
    @PostMapping
    public ResponseEntity<CreateLodgeResponseDto> createLodge(
            @RequestBody CreateLodgeRequestDto requestDto) {
        CreateLodgeResponseDto responseDto = lodgeService.createLodge(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    //객실단건조회

    //객실단건조회(내부)

    //객실수정

    //객실목록조회

    //host객실목록조회

    //host객실목록조회(내부)

    //객실검색


}
