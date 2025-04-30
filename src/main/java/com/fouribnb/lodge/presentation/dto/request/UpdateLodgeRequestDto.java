package com.fouribnb.lodge.presentation.dto.request;

import com.fouribnb.lodge.domain.entity.Amenities;
import com.fouribnb.lodge.domain.entity.RoomType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateLodgeRequestDto {

    private String lodgeName;
    private RoomType roomType;
    private Integer capacity;
    private String address;
    private Long pricePerNight;
    private String description;
    private Amenities amenities;

}
