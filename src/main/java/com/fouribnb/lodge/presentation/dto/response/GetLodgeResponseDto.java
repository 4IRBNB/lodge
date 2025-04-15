package com.fouribnb.lodge.presentation.dto.response;

import com.fouribnb.lodge.domain.entity.Amenities;
import com.fouribnb.lodge.domain.entity.LodgeStatus;
import com.fouribnb.lodge.domain.entity.RoomType;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetLodgeResponseDto {
    private UUID lodgeId;
    private Long hostId;
    private String lodgeName;
    private RoomType roomType;
    private int capacity;
    private String address;
    private Long pricePerNight;
    private String description;
    private Amenities amenities;
    private LodgeStatus lodgeStatus;

}
