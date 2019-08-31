package org.java.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService reService;
	@Autowired
	private HistoryService hiService;

	@RequestMapping("/createOrder")
	public String createOrder(@RequestParam Map<String, Object> map,
			HttpSession ses) {

		String userId = (String) ses.getAttribute("username");
		map.put("userId", userId);
		service.createOrder(map);

		return "redirect:/showPerson";

	}

	@RequestMapping("/showPerson")
	public String showPersonTask(Model model, HttpSession ses) {
		String userId = (String) ses.getAttribute("username");
		List<Map<String, Object>> list = service.showPersonTask(userId);
		model.addAttribute("list", list);

		return "/showPersonTask";

	}

	@RequestMapping("/submitOrder/{taskId}")
	public String submitOrder(@PathVariable("taskId") String taskId) {
		service.submitOrder(taskId);
		return "redirect:/showPerson";

	}

	@RequestMapping("/auditOrder/{taskId}/{orderId}/{defKey}")
	public String auditOrder(@PathVariable("taskId") String taskId,
			@PathVariable("orderId") String orderId,
			@PathVariable("defKey") String defKey,Model model) {
		Map<String, Object> map=service.findOrder(orderId);
		model.addAttribute("m", map);
		model.addAttribute("taskId", taskId);
		model.addAttribute("orderId", orderId);
		model.addAttribute("defKey", defKey);
		
		return "/showAudit";

	}
	
	@RequestMapping("submitAudit")
	public String submitAudit(@RequestParam Map<String, Object> map,HttpSession ses){
		String userId=(String) ses.getAttribute("username");
		map.put("username", userId);
		service.submitAudit(map);
		return "redirect:/showPerson";
		
	}

	@RequestMapping("/showProcess1")
	public String showProcessInstance(Model model) {
		List<Map<String, Object>> list = service.showProcessInstance();
		model.addAttribute("list", list);
		return "/showProcessInstance";

	}

	@RequestMapping("showActiveMap/{processInstanceId}")
	public String showActiveMap(
			@PathVariable("processInstanceId") String processInstanceId,
			Model model) {
		ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
		ProcessInstance instance = query.processInstanceId(processInstanceId).singleResult();
		String processDefinitionId=instance.getProcessDefinitionId();
		ProcessDefinitionEntity entity=(ProcessDefinitionEntity) reService.getProcessDefinition(processDefinitionId);
		String activityId=instance.getActivityId();
		ActivityImpl act = entity.findActivity(activityId);
		int height=act.getHeight();
		int width=act.getWidth();
		int x=act.getX();
		int y=act.getY();
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("w", width);
		model.addAttribute("h", height);
		
		String deploymentId = entity.getDeploymentId();
		String png=entity.getDiagramResourceName();
		
		model.addAttribute("deploymentId",deploymentId );
		model.addAttribute("png",png);
		return "/showActiveMap";

	}
	
	@RequestMapping("showHistoryTask/{processInstanceId}")
	public String showHistoryTask(@PathVariable("processInstanceId") String processInstanceId,Model model){
		HistoricTaskInstanceQuery query = hiService.createHistoricTaskInstanceQuery();
		List<HistoricTaskInstance> list = query.processInstanceId(processInstanceId).list();
		model.addAttribute("list", list);
		return "/historyTask";
		
	}

}
