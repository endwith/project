package com.ptteng.model;

import java.io.Serializable;

public class MessageRelationship implements Serializable {
    private Long id;

    private Long inforId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInforId() {
        return inforId;
    }

    public void setInforId(Long inforId) {
        this.inforId = inforId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MessageRelationship() {
    }

    public MessageRelationship(Long inforId, Long userId) {
        this.inforId = inforId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MessageRelationship{" +
                "id=" + id +
                ", inforId=" + inforId +
                ", userId=" + userId +
                '}';
    }
}