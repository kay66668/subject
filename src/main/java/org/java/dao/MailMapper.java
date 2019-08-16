package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Mail;

@Mapper
public interface MailMapper {
    int insert(Mail record);

    int insertSelective(Mail record);
}