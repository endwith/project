package com.ptteng.service;

import com.ptteng.model.MessageRelationship;



public interface MessageRelationshipService {
    int deleteByPrimaryKey(Long id);

    int insert(MessageRelationship record);

    int insertSelective(MessageRelationship record);

    MessageRelationship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageRelationship record);

    int updateByPrimaryKey(MessageRelationship record);
}