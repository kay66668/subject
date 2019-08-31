package org.java.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class ProcessDefinitionController {

	@Autowired
	private RepositoryService service;

	@RequestMapping("/deploy")
	public String deploy(@RequestParam("bpmn") MultipartFile bpmn,
			@RequestParam("png") MultipartFile png) throws Exception {

		String bpmnName = bpmn.getOriginalFilename();
		String pngName = png.getOriginalFilename();

		InputStream bpmn_in = bpmn.getInputStream();
		InputStream png_in = png.getInputStream();

		Deployment deploy = service.createDeployment()
				.addInputStream(bpmnName, bpmn_in)
				.addInputStream(pngName, png_in).deploy();
		return "redirect:/showProcess";
	//	return "redirect:showProcessDefinition.do";

	}

	@RequestMapping("/showProcess")
	public String showProcessDefinition(Model model) {
		ProcessDefinitionQuery query = service.createProcessDefinitionQuery();
		List<ProcessDefinition> list = query.list();
		model.addAttribute("list", list);
		return "/showProcessDefinition";

	}

	@RequestMapping("/delProcessDefinition/{deploymentId}")
	public String delProcessDefinition(
			@PathVariable("deploymentId") String deploymentId) {
		service.deleteDeployment(deploymentId, true);
		return "redirect:/showProcess";

	}

	@RequestMapping("/showResource/{deploymentId}/{name}")
	public void showResource(@PathVariable("deploymentId") String deploymentId,
			@PathVariable("name") String name, HttpServletResponse res) throws Exception {
		
		InputStream in = service.getResourceAsStream(deploymentId, name);
		OutputStream out=res.getOutputStream();
		byte[] b=new byte[8192];
		int len=0;
		while((len=in.read(b, 0, 8192))!=-1){
			out.write(b, 0, len);
		}
		out.close();
		in.close();

	}

}
