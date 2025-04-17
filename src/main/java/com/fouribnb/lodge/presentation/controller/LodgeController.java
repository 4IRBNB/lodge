package com.fouribnb.lodge.presentation.controller;

import com.fouribnb.lodge.application.service.LodgeService;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.request.UpdateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.UpdateLodgeResponseDto;
import com.fourirbnb.common.response.BaseResponse;
import com.fourirbnb.common.response.Pagination;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lodges")
public class LodgeController {

    private final LodgeService lodgeService;

    @PostMapping
    public BaseResponse<CreateLodgeResponseDto> createLodge(
            @RequestBody CreateLodgeRequestDto requestDto) {
        CreateLodgeResponseDto responseDto = lodgeService.createLodge(requestDto);
        return BaseResponse.SUCCESS(responseDto, "객실 생성 완료", HttpStatus.OK.value());
    }

    //객실단건조회
    @GetMapping("/{lodgeId}")
    public BaseResponse<GetLodgeResponseDto> getLodge(@PathVariable UUID lodgeId)
            throws NotFoundException {
        GetLodgeResponseDto responseDto = lodgeService.getLodge(lodgeId);
        return BaseResponse.SUCCESS(responseDto, "객실 단건 조회 완료", HttpStatus.OK.value());
    }

    //객실수정
    @PatchMapping("/{lodgeId}")
    public BaseResponse<UpdateLodgeResponseDto> updateLodge(@PathVariable UUID lodgeId,
            @RequestBody UpdateLodgeRequestDto requestDto)
            throws NotFoundException {
        UpdateLodgeResponseDto responseDto = lodgeService.updateLodge(lodgeId, requestDto);
        return BaseResponse.SUCCESS(responseDto, "객실 수정 완료", HttpStatus.OK.value());
    }

    //객실목록조회
    @GetMapping
    public BaseResponse<List<GetLodgeResponseDto>> getLodges(Pageable pageable) {
        Page<GetLodgeResponseDto> page = lodgeService.getLodges(pageable);

        Pagination pagination = new Pagination(
                page.getNumber(),
                (long) page.getSize(),
                page.getTotalPages(),
                (int) page.getTotalElements()
        );
        return BaseResponse.SUCCESS(
                page.getContent(),
                "객실 목록 조회 완료",
                pagination
        );

    }

    //객실삭제

    @DeleteMapping("/{lodgeId}")
    public ResponseEntity<Void> deleteLodge(@PathVariable UUID lodgeId) {
        lodgeService.deleteLodge(lodgeId);
        return ResponseEntity.noContent().build();
    }

    //host객실목록조회
    ///api/lodges/{userId}

    //host객실목록조회(내부)

    //객실검색
    //api/lodges/search?
    //page=1&size=10&sortBy=createdAt&isAsc=true




}
