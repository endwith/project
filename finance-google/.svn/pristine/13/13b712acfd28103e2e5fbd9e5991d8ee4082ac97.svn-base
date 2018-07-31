package com.ptteng.service;

import com.ptteng.model.User;

import java.util.List;


public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    User selectByPhoneNumber(String phone);
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> forSelect(Long a, Long b);
    List<User> select(Long a, Long b, Long id, String trueName, String phone, Integer status);
    Long selectCount();
    Long selectCountWithCondition();
}