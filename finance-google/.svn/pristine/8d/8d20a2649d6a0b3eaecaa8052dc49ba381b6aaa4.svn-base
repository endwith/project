package com.ptteng.service.impl;

import com.ptteng.dao.ModuleManageMapper;
import com.ptteng.dao.ModuleRoleManageMapper;
import com.ptteng.model.ModuleManage;
import com.ptteng.model.ModuleRole;
import com.ptteng.model.ModuleRoleManage;
import com.ptteng.service.ModuleManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModuleManageServiceImpl implements ModuleManageService {
    @Resource
    private ModuleManageMapper moduleManageMapper;
    @Resource
    private ModuleRoleManageMapper moduleRoleManageMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.moduleManageMapper.deleteByPrimaryKey(id);
    }
    @Override
    public  int deleteRole(String role){
        return this.moduleRoleManageMapper.deleteRole(role);
    }
    @Override
    public int insert(ModuleManage record) {
        return this.moduleManageMapper.insert(record);
    }
    @Override
    public int insert(ModuleRoleManage record){
        return this.moduleRoleManageMapper.insert(record);
    }
    @Override
    public int insertSelective(ModuleManage record) {
        return this.moduleManageMapper.insertSelective(record);
    }
    @Override
    public int updateByPrimaryKeySelective(ModuleRoleManage record){
        return this.moduleRoleManageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ModuleManage selectByPrimaryKey(Long id) {

        return this.moduleManageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ModuleManage record) {
        return this.moduleManageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ModuleManage record) {
        return this.moduleManageMapper.updateByPrimaryKey(record);
    }
    public List<ModuleRole> selectAll(){
        return this.moduleManageMapper.selectAll();
    }

    @Override
    public List<ModuleRole> selectFirst() {
        return moduleManageMapper.selectFirst();
    }

    @Override
    public List<ModuleRole> selectSecond(Long id) {
        return moduleManageMapper.selectSecond(id);
    }

    @Override
    public int deleteByModuleId(Long moduleId) {
        return moduleRoleManageMapper.deleteByModuleId(moduleId);
    }

    @Override
    public Long selectCount() {
        return moduleManageMapper.selectCount();
    }

    //分页查询
    public List<ModuleManage> forSelect(Long a, Long b){
        return this.moduleManageMapper.forSelect(a,b);
    }
    //分页模糊查询
    public List<ModuleManage> select(Long a,Long b,Long id,
                              String moduleName, Long parentModule, String founder){

        return this.moduleManageMapper.select(a,b,id,moduleName,parentModule,founder);
    }
    public List selectModuleId(String role){
        return this.moduleRoleManageMapper.selectModuleId(role);
    }

    @Override
    public List<ModuleRole> selectByRole(List role) {
        return this.moduleManageMapper.selectByRole( role);
    }
}