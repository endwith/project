package com.ptteng.dao;

import com.ptteng.model.ModuleRoleManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModuleRoleManageMapper {
    int insert(ModuleRoleManage record);

    int updateByPrimaryKeySelective(ModuleRoleManage record);
    List selectModuleId(String role);
    int deleteRole(String role);
    int deleteByModuleId(long moduleId);
}