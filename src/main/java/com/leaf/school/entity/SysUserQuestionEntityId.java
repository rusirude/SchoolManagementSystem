package com.leaf.school.entity;
/**
 * @Author : Rusiru De Silva
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SysUserQuestionEntityId implements Serializable {

    private String username;
    private Integer question;

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "question", nullable = false)
    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        result = prime
                * result
                + ((question == null) ? 0 : question.hashCode());

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
        if (!(obj instanceof SysUserQuestionEntityId)) {
            return false;
        }
        SysUserQuestionEntityId other = (SysUserQuestionEntityId) obj;
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        if (question == null) {
            if (other.question != null) {
                return false;
            }
        } else if (!question.equals(other.question)) {
            return false;
        }

        return true;
    }
}
