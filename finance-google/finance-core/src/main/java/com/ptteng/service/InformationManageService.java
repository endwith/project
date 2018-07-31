package com.ptteng.service;

import com.ptteng.model.InformationManage;



public interface InformationManageService {
    int deleteByPrimaryKey(Long id);

    int insert(InformationManage record);

    int insertSelective(InformationManage record);

    InformationManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InformationManage record);

    int updateByPrimaryKey(InformationManage record);
}