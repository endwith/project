package com.ptteng.model;

public class ModuleRole {
    private Long id;

    private String moduleName;

    private Long parentId;

    private String moduleUrl;

    @Override
    public String toString() {
        return "ModuleRole{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", parentId=" + parentId +
                ", moduleUrl='" + moduleUrl + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }
}
