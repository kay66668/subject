package org.java.service;

import org.java.entity.TMeet;

import java.util.List;

public interface MeetService {

    void add(TMeet meet);

    void update(TMeet meet);

    void del(Integer id);

    List<TMeet> getMeetList(int page, int rows, String createBy, String title);

    int getCount(String createBy, String title);
}
