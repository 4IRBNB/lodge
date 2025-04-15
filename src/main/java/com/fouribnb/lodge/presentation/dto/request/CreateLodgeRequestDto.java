package com.fouribnb.lodge.presentation.dto.request;

import com.fouribnb.lodge.domain.entity.Amenities;
import com.fouribnb.lodge.domain.entity.RoomType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateLodgeRequestDto {

    private Long hostId;
    private String lodgeName;
    private RoomType roomType;
    private int capacity;
    private String address;
    private Long pricePerNignt;
    private String description;
    private Amenities amenities;
}
