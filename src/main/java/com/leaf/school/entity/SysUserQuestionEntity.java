package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.*;

@Entity
@Table(name = "user_management.sys_user_question")
public class SysUserQuestionEntity extends BaseEntity {


    private SysUserQuestionEntityId id;
    private SysUserEntity sysUserEntity;
    private SecurityQuestionEntity questionEntity;
    private StatusEntity status;
    private String answer;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "username", nullable = false)),
            @AttributeOverride(name = "questionId", column = @Column(name = "question_id", nullable = false))
    }
    )
    public SysUserQuestionEntityId getId() {
        return id;
    }

    public void setId(SysUserQuestionEntityId id) {
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
    @JoinColumn(name = "question_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SecurityQuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(SecurityQuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    @Column(name = "answer", nullable = false)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
