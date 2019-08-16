package org.java.dao;

import org.java.entity.Mail;

public interface MailMapper {
    int insert(Mail record);

    int insertSelective(Mail record);
}