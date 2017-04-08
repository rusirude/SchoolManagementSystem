package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;

@Entity
@Table(name = "user_management.sys_role_screen_map")
public class SysRoleScreenMapEntity extends BaseEntity {
    private SysRoleScreenMapEntityId id;
    private SysRoleEntity sysRoleEntity;
    private SysScreenEntity sysScreenEntity;
    private StatusEntity statusEntity;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "role", column = @Column(name = "role", nullable = false)),
            @AttributeOverride(name = "screen", column = @Column(name = "screem", nullable = false))
    })
    public SysRoleScreenMapEntityId getId() {
        return id;
    }

    public void setId(SysRoleScreenMapEntityId id) {
        this.id = id;
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
    @JoinColumn(name = "screen", referencedColumnName = "id", insertable = false, updatable = false)
    public SysScreenEntity getSysScreenEntity() {
        return sysScreenEntity;
    }

    public void setSysScreenEntity(SysScreenEntity sysScreenEntity) {
        this.sysScreenEntity = sysScreenEntity;
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
