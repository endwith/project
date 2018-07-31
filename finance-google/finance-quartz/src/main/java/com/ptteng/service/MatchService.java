package com.ptteng.service;

import com.ptteng.model.Match;


public interface MatchService {
    int deleteByPrimaryKey(Long id);

    int insert(Match record);

    int insertSelective(Match record);

    Match selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Match record);

    int updateByPrimaryKey(Match record);
}