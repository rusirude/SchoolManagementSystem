package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;

@Entity
@Table(name = "user_management.sys_user")
public class SysUserEntity extends BaseEntity {

    private String username;
    private String password;
    private String name;
    private StatusEntity status;
    private String firstLogin;


    @Id
    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    @Column(name = "first_login", nullable = false)
    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }


}
