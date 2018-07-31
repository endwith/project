package com.ptteng.model;

import java.io.Serializable;

public class SonModule implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "SonModule{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", moduleId=" + moduleId +
                '}';
    }

    private String name;



    private String url;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    private long moduleId;


}
