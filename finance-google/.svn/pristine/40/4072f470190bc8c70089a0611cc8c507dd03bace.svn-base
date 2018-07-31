package com.ptteng.dao;

import com.ptteng.model.MessageRelationship;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageRelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageRelationship record);

    int insertSelective(MessageRelationship record);

    MessageRelationship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageRelationship record);

    int updateByPrimaryKey(MessageRelationship record);

    List<Long> selectByUserId(@Param("userId") Long userId);

    int deleteByInforId(@Param("inforId") Long inforId);
}