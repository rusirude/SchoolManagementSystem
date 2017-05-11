package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;


@Entity
@Table(name = "master_data.status")
public class StatusEntity extends BaseEntity {

    private Long id;
    private String code;
    private String description;
    private StatusCategoryEntity statusCategoryEntity;
    private Integer isActive;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)
    public StatusCategoryEntity getStatusCategoryEntity() {
        return statusCategoryEntity;
    }

    public void setStatusCategoryEntity(StatusCategoryEntity statusCategoryEntity) {
        this.statusCategoryEntity = statusCategoryEntity;
    }

    @Column(name = "is_active", nullable = false)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
