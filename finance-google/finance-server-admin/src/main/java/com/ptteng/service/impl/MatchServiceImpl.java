package com.ptteng.service.impl;

import com.ptteng.dao.MatchMapper;
import com.ptteng.model.Match;
import com.ptteng.service.MatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MatchServiceImpl implements MatchService {
@Resource
private MatchMapper matchMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Match record) {
        return this.matchMapper.insert(record);
    }

    @Override
    public int insertSelective(Match record) {
        return matchMapper.insertSelective(record);
    }

    @Override
    public Match selectByPrimaryKey(Long id) {
        return matchMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Match record) {
        return matchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Match record) {
        return matchMapper.updateByPrimaryKey(record);
    }
}