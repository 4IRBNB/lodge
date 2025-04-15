package com.fouribnb.lodge.domain.entity;

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


@Entity
@Table(name = "p_lodge")
@Getter
@NoArgsConstructor
public class Lodge {

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
}

