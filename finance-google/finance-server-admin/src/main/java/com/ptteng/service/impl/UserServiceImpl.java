package com.ptteng.service.impl;

import com.ptteng.dao.UserMapper;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Resource
  private UserMapper user;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.user.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return this.user.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return this.user.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return this.user.selectByPrimaryKey(id);
    }

    @Override
    public User selectByPhoneNumber(String phone){
        return this.user.selectByPhoneNumber(phone);
    }
    @Override
    public int updateByPrimaryKeySelective(User record) {
        return this.user.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return this.user.updateByPrimaryKey(record);
    }

    @Override
    public List<User> forSelect(Long a, Long b) {
        return this.user.forSelect(a,b);
    }

    @Override
    public List<User> select(Long a, Long b, Long id, String trueName, String phone, Integer status) {
        return this.user.select(a,b,id,trueName,phone,status);
    }

    @Override
    public Long selectCount() {
        return this.user.selectCount();
    }

    @Override
    public Long selectCountWithCondition() {
        return this.user.selectCountWithCondition();
    }


}