package com.ptteng.model;

import java.io.Serializable;
import java.util.List;

public class FirstModule implements Serializable {


    @Override
    public String toString() {
        return "FirstModule{" +
                "moduleName='" + moduleName + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", secondModules=" + secondModules +
                '}';
    }

    private String moduleName;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    public List<ModuleRole> getSecondModules() {
        return secondModules;
    }

    public void setSecondModules(List<ModuleRole> secondModules) {
        this.secondModules = secondModules;
    }

    private List<ModuleRole> secondModules;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
