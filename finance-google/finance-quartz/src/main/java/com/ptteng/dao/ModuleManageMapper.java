package com.ptteng.dao;

import com.ptteng.model.ModuleManage;
import com.ptteng.model.ModuleRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModuleManageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ModuleManage record);

    int insertSelective(ModuleManage record);

    ModuleManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ModuleManage record);

    int updateByPrimaryKey(ModuleManage record);
    List<ModuleRole> selectByRole(List role);
    List<ModuleRole> selectAll();
    List<ModuleRole> selectFirst();
    List<ModuleRole> selectSecond(long id);
    Long selectCount();
    //分页查询
    public List<ModuleManage> forSelect(@Param("a") Long a, @Param("b") Long b);

    //分页模糊查询
    public List<ModuleManage> select(@Param("a") Long a, @Param("b") Long b, @Param("id") Long id,
                                     @Param("moduleName") String moduleName,
                                     @Param("parentModule") Long parentModule,
                                     @Param("founder") String founder);
}

