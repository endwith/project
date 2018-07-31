package com.ptteng.service.impl;

import com.ptteng.dao.SuggestionMapper;
import com.ptteng.model.Suggestion;
import com.ptteng.service.SuggestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {
@Resource
private SuggestionMapper suggestionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return suggestionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Suggestion record) {
        return this.suggestionMapper.insert(record);
    }

    @Override
    public int insertSelective(Suggestion record) {
        return suggestionMapper.insertSelective(record);
    }
    @Override
    public     Suggestion selectByUserId(Long userId){
        return this.suggestionMapper.selectByUserId(userId);
    }
    @Override
    public Suggestion selectByPrimaryKey(Long id) {
        return suggestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Suggestion record) {
        return suggestionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Suggestion record) {
        return suggestionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Suggestion> forSelect(Long a, Long b) {
        return this.suggestionMapper.forSelect(a,b);
    }

    @Override
    public List<Suggestion> select(Long a, Long b, Long id, String suggeContent,String adviser, String phone) {
        return this.suggestionMapper.select(a,b,id,suggeContent,adviser,phone);
    }

    @Override
    public List<Object> selectSuggeByRead(Long userId, Long b) {
        return this.suggestionMapper.selectSuggeByRead(userId,b);
    }

    @Override
    public List<Object> selectSuggeContentById(Long id) {
        return this.suggestionMapper.selectSuggeContentById(id);
    }

    @Override
    public Long selectCount() {
        return this.suggestionMapper.selectCount();
    }

    @Override
    public Long selectCountWithCondition(Long id, String suggeContent, String adviser, String phone) {
        return this.suggestionMapper.selectCountWithCondition(id, suggeContent, adviser, phone);
    }
    @Override
    public long selectSuggeNoReadCount(Long id,Long time) {
        return this.suggestionMapper.selectSuggeNoReadCount( id,time);
    }
}