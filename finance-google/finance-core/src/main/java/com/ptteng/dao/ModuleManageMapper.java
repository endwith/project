package com.ptteng.dao;

import com.ptteng.model.ModuleManage;

public interface ModuleManageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ModuleManage record);

    int insertSelective(ModuleManage record);

    ModuleManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ModuleManage record);

    int updateByPrimaryKey(ModuleManage record);
}