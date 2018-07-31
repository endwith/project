package com.ptteng.dao;

import com.ptteng.model.Suggestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SuggestionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(Long id);
    Suggestion selectByUserId(Long userId);
    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKey(Suggestion record);
    //分页查询
    List<Suggestion> forSelect(@Param("a") Long a, @Param("b") Long b);
    //分页模糊查询
    List<Suggestion> select(@Param("a") Long a, @Param("b") Long b, @Param("id") Long id, @Param("suggeContent") String suggeContent, @Param("adviser") String adviser, @Param("phone") String phone);

    List<Object> selectSuggeByRead(@Param("userId") Long userId, @Param("b") Long b);
    List<Object> selectSuggeContentById(@Param("id") Long id);
    Long selectCount();
    Long selectCountWithCondition(@Param("id") Long id, @Param("suggeContent") String suggeContent, @Param("adviser") String adviser, @Param("phone") String phone);
}

