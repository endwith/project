package com.ptteng.service;

import com.ptteng.model.BackstageAccount;



public interface BackstageAccountService {
    int deleteByPrimaryKey(Long id);

    int insert(BackstageAccount record);

    int insertSelective(BackstageAccount record);

    BackstageAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackstageAccount record);

    int updateByPrimaryKey(BackstageAccount record);
}