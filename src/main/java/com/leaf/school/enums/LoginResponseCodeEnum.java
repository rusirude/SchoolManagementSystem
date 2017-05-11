package com.leaf.school.enums;

/**
 * @Author : Rusiru De Silva
 */
public enum LoginResponseCodeEnum {
    LOGIN_FAILED("LOGIN_FAILED"), ACCOUNT_LOCK("ACCOUNT_LOCK"), PASSWORD_RESET_REQUESTED("PASSWORD_RESET_REQUESTED"), FIRST_LOGIN("FIRST_LOGIN"),LOGIN_SUCCESS("LOGIN_SUCCESS"), ERROR("ERROR");
    private String code;

    LoginResponseCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static LoginResponseCodeEnum getEnum(String code) {
        switch (code) {
            case "LOGIN_FAILED":
                return LOGIN_FAILED;
            case "ACCOUNT_LOCK":
                return ACCOUNT_LOCK;
            case "PASSWORD_RESET_REQUESTED":
                return PASSWORD_RESET_REQUESTED;
            case "FIRST_LOGIN":
                return FIRST_LOGIN;
            case "LOGIN_SUCCESS":
                return LOGIN_SUCCESS;
            default:
                return ERROR;
        }
    }
}
