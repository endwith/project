package com.ptteng.dao;

import com.ptteng.model.BackstageAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BackstageAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackstageAccount record);

    int insertSelective(BackstageAccount record);

    BackstageAccount selectByPrimaryKey(Long id);
    BackstageAccount selectByPassword(String password);
    List<BackstageAccount> selectByAdmin(String admin);
    int updateByPrimaryKeySelective(BackstageAccount record);

    int updateByPrimaryKey(BackstageAccount record);
    //分页查询
    List<BackstageAccount> forSelect(@Param("a") Long a, @Param("b") Long b);
    //分页模糊查询
    List<BackstageAccount> select(@Param("a") Long a, @Param("b") Long b, @Param("id") Long id,
                                  @Param("adminRole") String adminRole,
                                  @Param("admin") String admin,
                                  @Param("founder") String founder);
    Long selectCount();
    Long selectCountWithCondition(@Param("id") Long id,
                                  @Param("adminRole") String adminRole,
                                  @Param("admin") String admin,
                                  @Param("founder") String founder);
}