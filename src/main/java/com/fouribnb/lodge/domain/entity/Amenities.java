package com.fouribnb.lodge.domain.entity;

public enum Amenities {
    //todo. 카테고리별 분류
    KITCHEN("주방"),
    TV("TV"),
    AIR_CONDITIONER("에어컨"),
    REFRIGERATOR("냉장고"),
    WIFI("와이파이"),
    WASHING_MACHINE("세탁기"),
    HAIR_DRYER("헤어드라이어"),
    TABLEWARE("식기류"),
    GAS_STOVE("가스레인지"),
    INDUCTION_COOKER("인덕션"),
    DINING_TABLE("식탁");

    private final String value;

    Amenities(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
