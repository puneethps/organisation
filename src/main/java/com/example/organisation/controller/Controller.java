package com.example.organisation.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.organisation.dto.Employee;
import com.example.organisation.dto.Role;
import com.example.organisation.service.EmployeeService;
import com.example.organisation.service.RoleService;
import com.fasterxml.jackson.annotation.JsonView;



@RestController
public class Controller {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RoleService roleService;
	
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute  Employee employee){
		
		employeeService.addEmployee(employee);
		
		return "Success";
		
		
	}
	
	@RequestMapping(value="/getOrgHierarchyByRole/{roleName}", method = RequestMethod.GET)
	public Role getOrgHierarchy(@PathVariable String roleName){
			
		return roleService.getRoleHierarchy(roleName);

	}
	
	@JsonView(com.example.organisation.views.View.EmployeeHierarchyView.class)
	@RequestMapping(value="/getOrgHierarchyByEmpId/{empId}", method = RequestMethod.GET)
	public Employee getOrgHierarchyByEmpId(@PathVariable String empId){
			
		return employeeService.getEmployeeHirerachy(Integer.parseInt(empId));

	}
	
	
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	@RequestMapping(value="/getTopTenEmployeesBySalary", method = RequestMethod.GET)
	public List<Employee> getTopTenEmployeesBySalary(){
		
		return employeeService.getTopTenEmployeesBySalary();

	}
	
	
	@RequestMapping(value="/deleteEmployee/{empId}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable String empId){
		
		employeeService.deleteEmployee(Integer.parseInt(empId));
		return "Success";
	}
	
	
	
	

}
