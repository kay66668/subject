package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Recruit;

@Mapper
public interface RecruitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruit record);

    int insertSelective(Recruit record);

    Recruit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruit record);

    int updateByPrimaryKey(Recruit record);
}