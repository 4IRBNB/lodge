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

@Entity
@Table(name = "p_lodge")
public class Lodge {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "lodge_id")
    private UUID id;

    @Column(nullable = false, name = "host_id")
    private UUID hostId;

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
    private String discription;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Amenities amenities;

    @Column(nullable = false, name = "lodge_status")
    @Enumerated(EnumType.STRING)
    private LodgeStatus lodgeStatus;

    //todo. 비어있음/투숙중 상태가 추가되어야 할지?




}
