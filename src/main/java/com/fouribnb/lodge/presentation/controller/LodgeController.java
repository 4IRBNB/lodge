package com.fouribnb.lodge.presentation.controller;

import com.fouribnb.lodge.application.service.LodgeService;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.request.UpdateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.UpdateLodgeResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/{lodgeId}")
    public ResponseEntity<GetLodgeResponseDto> getLodge(@PathVariable UUID lodgeId)
            throws NotFoundException {
        GetLodgeResponseDto responseDto = lodgeService.getLodge(lodgeId);
        return ResponseEntity.ok(responseDto);
    }

    //객실수정
    @PatchMapping("/{lodgeId}")
    public ResponseEntity<UpdateLodgeResponseDto> updateLodge(@PathVariable UUID lodgeId,
            @RequestBody UpdateLodgeRequestDto requestDto)
            throws NotFoundException {
        UpdateLodgeResponseDto responseDto = lodgeService.updateLodge(lodgeId, requestDto);
        return ResponseEntity.ok(responseDto);
    }
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
