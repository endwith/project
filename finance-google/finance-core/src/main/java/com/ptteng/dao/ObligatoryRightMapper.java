package com.ptteng.dao;

import com.ptteng.model.ObligatoryRight;

public interface ObligatoryRightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ObligatoryRight record);

    int insertSelective(ObligatoryRight record);

    ObligatoryRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ObligatoryRight record);

    int updateByPrimaryKey(ObligatoryRight record);
}