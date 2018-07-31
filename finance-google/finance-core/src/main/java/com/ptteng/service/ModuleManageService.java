package com.ptteng.service;

import com.ptteng.model.ModuleManage;



public interface ModuleManageService {
    int deleteByPrimaryKey(Long id);

    int insert(ModuleManage record);

    int insertSelective(ModuleManage record);

    ModuleManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ModuleManage record);

    int updateByPrimaryKey(ModuleManage record);
}