package com.fouribnb.lodge.presentation.dto.request;

import com.fouribnb.lodge.domain.entity.Amenities;
import com.fouribnb.lodge.domain.entity.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateLodgeRequestDto {

    @NotBlank
    private String lodgeName;

    @NotBlank
    private RoomType roomType;

    @NotBlank
    private int capacity;

    @NotBlank
    private String address;

    @NotBlank
    private Long pricePerNight;

    private String description;
    private Amenities amenities;
}
