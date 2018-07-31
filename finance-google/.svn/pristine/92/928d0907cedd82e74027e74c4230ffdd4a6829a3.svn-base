package com.ptteng.service;

import com.ptteng.model.ModuleManage;
import com.ptteng.model.ModuleRole;
import com.ptteng.model.ModuleRoleManage;

import java.util.List;


public interface ModuleManageService {
    int deleteByPrimaryKey(Long id);
    int deleteRole(String role);
    int insert(ModuleManage record);

    int insertSelective(ModuleManage record);

    ModuleManage selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(ModuleRoleManage record);
    int updateByPrimaryKeySelective(ModuleManage record);
    int updateByPrimaryKey(ModuleManage record);
    //分页查询
    List<ModuleManage> forSelect(Long a, Long b);
    //分页模糊查询
    List<ModuleManage> select(Long a, Long b, Long id, String moduleName, Long parentModule,
                              String founder);
    //角色模块关系表查出对应角色模块id
    List selectModuleId(String role);
    List<ModuleRole> selectByRole(List role);
    int insert(ModuleRoleManage record);
    List<ModuleRole> selectAll();
    List<ModuleRole> selectFirst();
    List<ModuleRole> selectSecond(Long id);
    int deleteByModuleId(Long moduleId);
    Long selectCount();
}