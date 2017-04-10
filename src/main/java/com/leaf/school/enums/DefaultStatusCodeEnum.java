package com.leaf.school.enums;

/**
 * @Author : Rusiru De Silva
 */
public enum DefaultStatusCodeEnum {
    ACTIVE("ACTIVE"), DEACT("DEACT"),DELETE("DELETE");
    private String code;

    DefaultStatusCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DefaultStatusCodeEnum getEnum(String code) {
        switch (code) {
            case "ACTIVE":
                return ACTIVE;
            case "DEACT":
                return DEACT;
            default:
                return DELETE;
        }
    }
}
