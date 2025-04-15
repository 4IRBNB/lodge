package com.fouribnb.lodge.presentation.mapper;

import com.fouribnb.lodge.domain.entity.Lodge;
import com.fouribnb.lodge.domain.entity.LodgeStatus;
import com.fouribnb.lodge.presentation.dto.request.CreateLodgeRequestDto;
import com.fouribnb.lodge.presentation.dto.response.CreateLodgeResponseDto;
import com.fouribnb.lodge.presentation.dto.response.GetLodgeResponseDto;

public class LodgeMapper {

    public static Lodge CreateLodgeRequestDtoToEntity(CreateLodgeRequestDto dto) {
        return Lodge.builder()
                .lodgeName(dto.getLodgeName())
                .hostId(dto.getHostId())
                .roomType(dto.getRoomType())
                .address(dto.getAddress())
                .capacity(dto.getCapacity())
                .description(dto.getDescription())
                .pricePerNight(dto.getPricePerNignt())
                .amenities(dto.getAmenities())
                .lodgeStatus(LodgeStatus.IN_SERVICE)
                .build();
    }

    public static CreateLodgeResponseDto EntityToCreateLodgeRequestDto(Lodge lodge) {
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

    public static GetLodgeResponseDto EntityToGetLodgeRequestDto(Lodge lodge) {
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

}
