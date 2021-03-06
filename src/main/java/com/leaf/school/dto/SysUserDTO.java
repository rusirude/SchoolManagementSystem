package com.leaf.school.dto;

/**
 * @Author : Rusiru De Silva
 */

public class SysUserDTO extends BaseDTO {

    private String username;
    private String password;
    private String name;
    private Long status;
    private String statusCode;
    private String statusDescription;
    private String firstLogin;
    private String passwordResetRequested;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getPasswordResetRequested() {
        return passwordResetRequested;
    }

    public void setPasswordResetRequested(String passwordResetRequested) {
        this.passwordResetRequested = passwordResetRequested;
    }
}
