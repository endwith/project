package com.ptteng.dao;

import com.ptteng.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User selectByPhoneNumber(@Param("phone") String phone);
    //动态更新
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //分页查询
    List<User> forSelect(@Param("a") Long a, @Param("b") Long b);
    //分页模糊查询
    List<User> select(@Param("a") Long a, @Param("b") Long b, @Param("id") Long id, @Param("trueName") String trueName, @Param("phone") String phone, @Param("status") int status);
    Long selectCount();
    Long selectCountWithCondition();
}