package com.fouribnb.lodge.domain.entity;

public enum RoomType {
    HOTEL("호텔"),
    PENSION("펜션"),
    HANOK("한옥"),
    MOTEL("모텔"),
    HOSTEL("호스텔"),
    APARTMENT("아파트"),
    VILLA("빌라"),
    DETACHED_HOUSE("단독주택"),
    STUDIO_APARTMENT("원룸");

    private final String value;

    RoomType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
