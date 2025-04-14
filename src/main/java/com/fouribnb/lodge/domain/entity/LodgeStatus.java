package com.fouribnb.lodge.domain.entity;

public enum LodgeStatus {
    IN_SERVICE("운영중"),
    UNDER_INSPECTION("점검중"),
    UNDER_REPAIR("수리중");




    private final String value;

    LodgeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
