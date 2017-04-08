package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;


@Entity
@Table(name = "master_data.status")
public class StatusEntity extends BaseEntity {

    private Integer id;
    private String code;
    private String descripion;
    private Integer isActive;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = true)
    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    @Column(name = "is_active", nullable = false)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
