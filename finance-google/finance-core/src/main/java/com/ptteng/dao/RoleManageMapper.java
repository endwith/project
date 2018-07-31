package com.ptteng.dao;

import com.ptteng.model.RoleManage;

public interface RoleManageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleManage record);

    int insertSelective(RoleManage record);

    RoleManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleManage record);

    int updateByPrimaryKey(RoleManage record);
}