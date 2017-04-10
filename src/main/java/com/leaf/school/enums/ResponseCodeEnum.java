package com.leaf.school.enums;

/**
 * @Author : Rusiru De Silva
 */
public enum ResponseCodeEnum {
    SUCCESS("SUCCESS"), ERROR("ERROR");
    private String code;

    ResponseCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ResponseCodeEnum getEnum(String code) {
        switch (code) {
            case "SUCCESS":
                return SUCCESS;
            default:
                return ERROR;
        }
    }
}
