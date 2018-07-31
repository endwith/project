package com.ptteng.model;

import java.io.Serializable;

public class ProductRecommend implements Serializable {
    private Long id;

    private String product;

    private String picture;

    private String founder;

    private Long createAt;

    private String modifier;

    private Long updateAt;

    private Integer status;

    private String title;

    private String url;

    private Integer intervals;

    private Integer recommendStatus;

    private Integer bannerStatus;

    private Long pushTime;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getInterval() {
        return intervals;
    }

    public void setInterval(Integer interval) {
        this.intervals = interval;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getBannerStatus() {
        return bannerStatus;
    }

    public void setBannerStatus(Integer bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    public Long getPushTime() {
        return pushTime;
    }

    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ProductRecommend() {
    }

    public ProductRecommend( String product, String picture, String founder, Long createAt, String modifier, Long updateAt, Integer status, String title, String url, Integer intervals, Integer recommendStatus, Integer bannerStatus, Long pushTime, Integer type) {
        this.product = product;
        this.picture = picture;
        this.founder = founder;
        this.createAt = createAt;
        this.modifier = modifier;
        this.updateAt = updateAt;
        this.status = status;
        this.title = title;
        this.url = url;
        this.intervals = intervals;
        this.recommendStatus = recommendStatus;
        this.bannerStatus = bannerStatus;
        this.pushTime = pushTime;
        this.type = type;
    }
}