package com.fouribnb.lodge.presentation.controller;

import com.fouribnb.lodge.application.service.LodgeService;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fourirbnb.common.response.BaseResponse;
import com.fourirbnb.common.response.Pagination;
import com.fourirbnb.common.security.AuthenticatedUser;
import com.fourirbnb.common.security.RoleCheck;
import com.fourirbnb.common.security.UserInfo;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/lodges")
public class LodgeInternalController {

    private final LodgeService lodgeService;

    //객실단건조회_내부
    @RoleCheck({"MASTER", "MANAGER", "HOST", "CUSTOMER"})
    @GetMapping("/{lodgeId}")
    public ResponseEntity<GetLodgeResponseDto> getInternalLodge(@PathVariable UUID lodgeId)
            throws NotFoundException {
        GetLodgeResponseDto responseDto = lodgeService.getLodge(lodgeId);
        return ResponseEntity.ok(responseDto);
    }

    //객실목록조회
    @RoleCheck({"MASTER", "MANAGER", "HOST", "CUSTOMER"})
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

    //host객실목록조회
    @RoleCheck({"MASTER", "MANAGER", "HOST"})
    @GetMapping("/me")
    public BaseResponse<List<GetLodgeResponseDto>> getHostLodges(Pageable pageable,
            @AuthenticatedUser UserInfo userInfo) {
        Page<GetLodgeResponseDto> page = lodgeService.getHostLodges(pageable, userInfo);

        Pagination pagination = new Pagination(
                page.getNumber(),
                (long) page.getSize(),
                page.getTotalPages(),
                (int) page.getTotalElements()
        );
        return BaseResponse.SUCCESS(
                page.getContent(),
                "호스트_나의객실목록 조회 완료",
                pagination
        );
    }

}
