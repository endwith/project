package com.ptteng.model;

public class Module {
    private Integer id;

    private Integer ownId;

    private String module;

    private Integer parentId;

    private String url;

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", ownId=" + ownId +
                ", module='" + module + '\'' +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}