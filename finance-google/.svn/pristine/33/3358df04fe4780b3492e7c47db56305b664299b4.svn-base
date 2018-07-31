package com.ptteng.service;

import com.ptteng.model.BackstageAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BackstageAccountService {
    int deleteByPrimaryKey(Long id);

    int insert(BackstageAccount record);

    int insertSelective(BackstageAccount record);

    BackstageAccount selectByPrimaryKey(Long id);
    List<BackstageAccount> selectByAdmin(String admin);
    BackstageAccount selectByPassword(String password);
    int updateByPrimaryKeySelective(BackstageAccount record);

    int updateByPrimaryKey(BackstageAccount record);
    //分页查询
    List<BackstageAccount> forSelect( Long a,Long b);
    //分页模糊查询
    List<BackstageAccount> select( Long a, Long b, Long id,String adminRole,String admin, String founder);
    Long selectCount();
    Long selectCountWithCondition(Long id, String adminRole, String admin, String founder);
}