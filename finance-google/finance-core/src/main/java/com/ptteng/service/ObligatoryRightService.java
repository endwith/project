package com.ptteng.service;

import com.ptteng.model.ObligatoryRight;



public interface ObligatoryRightService {
    int deleteByPrimaryKey(Long id);

    int insert(ObligatoryRight record);

    int insertSelective(ObligatoryRight record);

    ObligatoryRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ObligatoryRight record);

    int updateByPrimaryKey(ObligatoryRight record);
}