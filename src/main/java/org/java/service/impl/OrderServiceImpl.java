package org.java.service.impl;

import java.util.*;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.java.dao.OrderMapper;
import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper mapper;
	@Autowired
	private RuntimeService service;
	@Autowired
	private TaskService taskService;
	@Autowired
	private IdentityService identityService;

	public void createOrder(Map<String, Object> map) {

		String id = UUID.randomUUID().toString();
		String processDefinitionKey = "myProcess";
		String userId=map.get("userId").toString();
		Map map1=new HashMap();
		map1.put("startUserId",userId);
		identityService.setAuthenticatedUserId(userId);
		ProcessInstance instance = service.startProcessInstanceByKey(
				processDefinitionKey, id,map1);
		map.put("createTime", new Date());
		map.put("id", id);
		map.put("processInstanceId", instance.getProcessInstanceId());
		mapper.createOrder(map);
	}

	public List<Map<String, Object>> showPersonTask(String userId) {
		TaskQuery query = taskService.createTaskQuery();
		query.taskAssignee(userId);
		List<Task> tasklist = query.list();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for(Task k:tasklist){
			String processInstanceId=k.getProcessInstanceId();
			Map<String, Object> map=mapper.findOrder(processInstanceId);
			map.put("taskId", k.getId());
			map.put("taskName", k.getName());
			map.put("processInstanceId", k.getProcessInstanceId());
			map.put("assignee", k.getAssignee());
			map.put("createTaskTime", k.getCreateTime());
			map.put("defKey", k.getTaskDefinitionKey());
			list.add(map);
			
		}

		return list;
	}

	public List<Map<String, Object>> showProcessInstance() {
		ProcessInstanceQuery query = service.createProcessInstanceQuery();
		List<ProcessInstance> list = query.list();
		List<Map<String, Object>> list1=new ArrayList<Map<String,Object>>();
		for(ProcessInstance k:list){
			String instanceId=k.getProcessInstanceId();
			Map<String, Object> m=mapper.findOrder(instanceId);
			
			m.put("processInstanceId", k.getProcessInstanceId());
			m.put("processDefinitionId", k.getProcessDefinitionId());
			m.put("activityId", k.getActivityId());
			
			list1.add(m);
		}
		return list1;
	}

	public Map<String, Object> findOrder(String orderId) {
		
		return mapper.findOrderById(orderId);
	}

	public void submitAudit(Map<String, Object> map) {
		String val=map.get("defKey").toString();
		String st=map.get("status").toString();
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.put(val, st);
		
		String taskId=(String) map.get("taskId");
		taskService.complete(taskId,variables);
		
		String id=UUID.randomUUID().toString();
		String userId= (String) map.get("username");
		Date createtime=new Date();
		map.put("id", id);
		map.put("createtime", createtime);
		map.put("userId",userId);
		System.out.println(map);
		mapper.submitAudit(map);
		
	}

	public void submitOrder(String taskId) {
		taskService.complete(taskId);
		
	}

}
