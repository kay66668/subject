package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface OrderMapper {
	
	public void createOrder(Map<String, Object> map);
	
	public Map<String,Object> findOrder(String processInstanceId);
	
	public Map<String,Object> findOrderById(String id);
	
	public void submitAudit(Map<String, Object> map);
}
