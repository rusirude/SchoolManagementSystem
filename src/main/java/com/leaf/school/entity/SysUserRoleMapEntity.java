package com.leaf.school.entity;

/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;

@Entity
@Table(name = "user_management.sys_user_role_map")
public class SysUserRoleMapEntity extends BaseEntity {

    private SysUserRoleMapEntityId id;
    private SysUserEntity sysUserEntity;
    private SysRoleEntity sysRoleEntity;
    private StatusEntity statusEntity;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "username", nullable = false)),
            @AttributeOverride(name = "role", column = @Column(name = "role", nullable = false))
    }
    )
    public SysUserRoleMapEntityId getId() {
        return id;
    }

    public void setId(SysUserRoleMapEntityId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role", referencedColumnName = "id", insertable = false, updatable = false)
    public SysRoleEntity getSysRoleEntity() {
        return sysRoleEntity;
    }

    public void setSysRoleEntity(SysRoleEntity sysRoleEntity) {
        this.sysRoleEntity = sysRoleEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }
}
