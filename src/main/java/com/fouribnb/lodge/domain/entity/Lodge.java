package com.fouribnb.lodge.domain.entity;

import com.fouribnb.lodge.presentation.dto.request.UpdateLodgeRequestDto;
import com.fourirbnb.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;


@Entity
@Table(name = "p_lodge")
@Getter
@NoArgsConstructor
@FilterDef(name = "deletedFilter")
@Filter(name = "deletedFilter", condition = "deleted_at IS NULL")
public class Lodge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "lodge_id")
    private UUID id;

    @Column(nullable = false, name = "host_id")
    private Long hostId;

    @Column(nullable = false, name = "lodge_name")
    private String lodgeName;

    @Column(nullable = false, name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, name = "price_per_night")
    private long pricePerNight;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Amenities amenities;
    //todo. amenities 여러 개 선택 가능하게 변경예정

    @Column(nullable = false, name = "lodge_status")
    @Enumerated(EnumType.STRING)
    private LodgeStatus lodgeStatus;

    //todo. 비어있음/투숙중 상태가 추가되어야 할지?

    @Builder
    public Lodge(Long hostId, String lodgeName, RoomType roomType, int capacity, String address,
            long pricePerNight, String description, Amenities amenities, LodgeStatus lodgeStatus) {
        this.hostId = hostId;
        this.lodgeName = lodgeName;
        this.roomType = roomType;
        this.capacity = capacity;
        this.address = address;
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.amenities = amenities;
        this.lodgeStatus = lodgeStatus;
    }

    public void update(UpdateLodgeRequestDto requestDto) {
        this.lodgeName = requestDto.getLodgeName();
        this.roomType = requestDto.getRoomType();
        this.capacity = requestDto.getCapacity();
        this.address = requestDto.getAddress();
        this.pricePerNight = requestDto.getPricePerNight();
        this.description = requestDto.getDescription();
        this.amenities = requestDto.getAmenities();
    }

}

