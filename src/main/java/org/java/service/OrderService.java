package org.java.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
	
	public void createOrder(Map<String, Object> map);
	
	public List<Map<String, Object>> showPersonTask(String userId);
	
	public List<Map<String, Object>> showProcessInstance();
	
	public Map<String, Object> findOrder(String orderId);
	
	public void submitAudit(Map<String, Object> map);
	
	public void submitOrder(String taskId);
}
