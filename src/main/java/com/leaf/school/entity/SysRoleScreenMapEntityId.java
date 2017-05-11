package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SysRoleScreenMapEntityId implements Serializable {

    private Long role;
    private Long screen;

    @Column(name = "role", nullable = false)
    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    @Column(name = "screen", nullable = false)
    public Long getScreen() {
        return screen;
    }

    public void setScreen(Long screen) {
        this.screen = screen;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((role == null) ? 0 : role.hashCode());
        result = prime
                * result
                + ((screen == null) ? 0 : screen.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SysUserQuestionMapEntityId)) {
            return false;
        }
        SysRoleScreenMapEntityId other = (SysRoleScreenMapEntityId) obj;
        if (role == null) {
            if (other.role != null) {
                return false;
            }
        } else if (!role.equals(other.role)) {
            return false;
        }
        if (screen == null) {
            if (other.screen != null) {
                return false;
            }
        } else if (!screen.equals(other.screen)) {
            return false;
        }

        return true;
    }
}
