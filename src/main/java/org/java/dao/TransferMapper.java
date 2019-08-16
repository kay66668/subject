package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Transfer;

@Mapper
public interface TransferMapper {
    int deleteByPrimaryKey(Integer historyid);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(Integer historyid);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);
}