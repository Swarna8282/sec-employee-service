package com.fedex.sad;

import java.security.Principal;
import java.util.Arrays;
//import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	
	private Logger myLog = LoggerFactory.getLogger(this.getClass());
	
	public List<Employee> empList = Arrays.asList(
		new Employee (100, "First1 Last1", "Developer"),
		new Employee (200, "First2 Last2", "Manager"),
		new Employee (300, "First3 Last3", "Tester"),
		new Employee (400, "First4 Last4", "Admin"),
		new Employee (500, "First5 Last5", "Developer"),
		new Employee (600, "First6 Last6", "Manager"),
		new Employee (700, "First7 Last7", "Admin")
	);
	
	@RequestMapping (value= {"/", "/all"})
	public String getAllEmployees (Model mdl) {
		
		mdl.addAttribute("employees", empList);
		myLog.info("EmployeeController ::: getAllEmployees() ::: SIZE = "+empList.size());
		
		return "employees";
	}
	
	// To check if the Principal is passes from Zuul to Employees Service or not
	@RequestMapping ("/userInfo")
	@ResponseBody
//	public String getUserInfo (Principal pal) {
		public String getUserInfo (HttpServletRequest req) {
		myLog.info("EmployeeController ::: getUserInfo() ::: HttpServletRequest = "+req);			
		
		Principal pal = req.getUserPrincipal();		
		if (pal != null) {
			myLog.info("EmployeeController ::: getUserInfo() ::: Principal = "+pal.toString());			
		} else {
			return "EmployeeController ::: getUserInfo() ::: Principal is NULL";
		}		
		return pal.toString();
	}
}
