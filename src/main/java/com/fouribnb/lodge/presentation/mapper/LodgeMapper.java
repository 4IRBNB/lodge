package com.fouribnb.lodge.presentation.mapper;

import com.fouribnb.lodge.domain.entity.Lodge;
import com.fouribnb.lodge.domain.entity.LodgeStatus;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.UpdateLodgeResponseDto;

public class LodgeMapper {

    public static Lodge createToEntity(CreateLodgeRequestDto dto, Long currentHostId) {
        return Lodge.builder()
                .lodgeName(dto.getLodgeName())
                .hostId(currentHostId)
                .roomType(dto.getRoomType())
                .address(dto.getAddress())
                .capacity(dto.getCapacity())
                .description(dto.getDescription())
                .pricePerNight(dto.getPricePerNight())
                .amenities(dto.getAmenities())
                .lodgeStatus(LodgeStatus.IN_SERVICE)
                .build();
    }

    public static CreateLodgeResponseDto createToResponse(Lodge lodge) {
        return CreateLodgeResponseDto.builder()
                .lodgeId(lodge.getId())
                .hostId(lodge.getHostId())
                .lodgeName(lodge.getLodgeName())
                .roomType(lodge.getRoomType())
                .address(lodge.getAddress())
                .capacity(lodge.getCapacity())
                .description(lodge.getDescription())
                .pricePerNight(lodge.getPricePerNight())
                .amenities(lodge.getAmenities())
                .lodgeStatus(lodge.getLodgeStatus())
                .build();
    }

    public static GetLodgeResponseDto getToResponse(Lodge lodge) {
        return GetLodgeResponseDto.builder()
                .lodgeId(lodge.getId())
                .hostId(lodge.getHostId())
                .lodgeName(lodge.getLodgeName())
                .roomType(lodge.getRoomType())
                .address(lodge.getAddress())
                .capacity(lodge.getCapacity())
                .description(lodge.getDescription())
                .pricePerNight(lodge.getPricePerNight())
                .amenities(lodge.getAmenities())
                .lodgeStatus(lodge.getLodgeStatus())
                .build();
    }


    public static UpdateLodgeResponseDto updateToResponse(Lodge lodge) {
        return UpdateLodgeResponseDto.builder()
                .lodgeId(lodge.getId())
                .hostId(lodge.getHostId())
                .lodgeName(lodge.getLodgeName())
                .roomType(lodge.getRoomType())
                .address(lodge.getAddress())
                .capacity(lodge.getCapacity())
                .description(lodge.getDescription())
                .pricePerNight(lodge.getPricePerNight())
                .amenities(lodge.getAmenities())
                .lodgeStatus(lodge.getLodgeStatus())
                .build();
    }

}
