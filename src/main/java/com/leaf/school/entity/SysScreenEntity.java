package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;

@Entity
@Table(name = "user_management.sys_screen")
public class SysScreenEntity extends BaseEntity {

    private Long id;
    private String screenName;
    private String url;
    private Integer level;
    private SysScreenEntity parent;
    private StatusEntity statusEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "screen_name", nullable = false)
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Column(name = "url", nullable = true, unique = true)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent", nullable = true)
    public SysScreenEntity getParent() {
        return parent;
    }

    public void setParent(SysScreenEntity parent) {
        this.parent = parent;
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
