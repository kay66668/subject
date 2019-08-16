package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Officesupplies;

@Mapper
public interface OfficesuppliesMapper {
    int deleteByPrimaryKey(Integer goodsid);

    int insert(Officesupplies record);

    int insertSelective(Officesupplies record);

    Officesupplies selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(Officesupplies record);

    int updateByPrimaryKey(Officesupplies record);
}