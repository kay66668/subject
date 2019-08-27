package org.java.service;

import org.java.entity.Userinfo;
import org.java.util.UserinfoMessage;

import java.util.List;
import java.util.Map;

public interface UserinfoService {

    public void add(Userinfo userinfo);

    public void update(Userinfo userinfo);

    public void del(Integer userid);

    public List<UserinfoMessage> getList(int page, int rows, String tel, String postbox);

    public int getCount(String tel,String postbox);
}
