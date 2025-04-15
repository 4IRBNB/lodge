package com.fouribnb.lodge.presentation.controller;

import com.fouribnb.lodge.application.service.LodgeService;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    //

    //객실수정
    ///api/lodges/{lodgeId}

    //객실목록조회
    ///api/lodges

    //host객실목록조회
    ///api/lodges/{userId}

    //host객실목록조회(내부)

    //객실검색
    //api/lodges/search?
    //page=1&size=10&sortBy=createdAt&isAsc=true

    //객실삭제
    ///api/lodges/{lodgeId}


}
