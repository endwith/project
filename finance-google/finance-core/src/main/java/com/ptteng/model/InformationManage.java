package com.ptteng.model;

public class InformationManage {
    private Long id;

    private String inforId;

    private String inforTitle;

    private String founder;

    private Long createAt;

    private String modifier;

    private Long updateAt;

    private Integer inforStatus;

    private Long sendTime;

    private String inforContent;

    private String inforPicture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInforId() {
        return inforId;
    }

    public void setInforId(String inforId) {
        this.inforId = inforId == null ? null : inforId.trim();
    }

    public String getInforTitle() {
        return inforTitle;
    }

    public void setInforTitle(String inforTitle) {
        this.inforTitle = inforTitle == null ? null : inforTitle.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getInforStatus() {
        return inforStatus;
    }

    public void setInforStatus(Integer inforStatus) {
        this.inforStatus = inforStatus;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public String getInforContent() {
        return inforContent;
    }

    public void setInforContent(String inforContent) {
        this.inforContent = inforContent == null ? null : inforContent.trim();
    }

    public String getInforPicture() {
        return inforPicture;
    }

    public void setInforPicture(String inforPicture) {
        this.inforPicture = inforPicture == null ? null : inforPicture.trim();
    }
}