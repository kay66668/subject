package org.java.dao;

import org.java.entity.TMeetingroom;
import org.java.entity.TMeetingroomKey;

public interface TMeetingroomMapper {
    int deleteByPrimaryKey(TMeetingroomKey key);

    int insert(TMeetingroom record);

    int insertSelective(TMeetingroom record);

    TMeetingroom selectByPrimaryKey(TMeetingroomKey key);

    int updateByPrimaryKeySelective(TMeetingroom record);

    int updateByPrimaryKey(TMeetingroom record);
}