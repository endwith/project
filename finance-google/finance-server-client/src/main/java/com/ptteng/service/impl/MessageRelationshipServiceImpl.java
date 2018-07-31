package com.ptteng.service.impl;

import com.ptteng.dao.MessageRelationshipMapper;
import com.ptteng.model.MessageRelationship;
import com.ptteng.service.MessageRelationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageRelationshipServiceImpl implements MessageRelationshipService {
@Resource
private MessageRelationshipMapper messageRelationshipMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return messageRelationshipMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MessageRelationship record) {
        return this.messageRelationshipMapper.insert(record);
    }

    @Override
    public int insertSelective(MessageRelationship record) {
        return messageRelationshipMapper.insertSelective(record);
    }

    @Override
    public MessageRelationship selectByPrimaryKey(Long id) {
        return messageRelationshipMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MessageRelationship record) {
        return messageRelationshipMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MessageRelationship record) {
        return messageRelationshipMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Long> selectByUserId(Long userId) {
        return messageRelationshipMapper.selectByUserId(userId);
    }
}