package com.example.organisation.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.organisation.dto.Employee;
import com.example.organisation.repository.EmployeeRepository;
import com.example.organisation.repository.RoleRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository; 

	public void addEmployee(Employee e){				

		Employee employee=employeeRepository.getEmpByEmpId(e.getEmpId());
		if(employee==null){
			employee=new Employee();
		}
		employee.setName(e.getName());
		employee.setEmpId(e.getEmpId());
		employee.setRole(roleRepository.getRoleByRoleId(e.getRoleId()));
		employee.setAge(e.getAge());
		employee.setDateOfBirth(e.getDateOfBirth());
		employee.setJoinDate(e.getJoinDate());
		employee.setLastDate(e.getLastDate());
		employee.setSalary(e.getSalary());
		employee.setStatus("Active");
		if(null!=e.getManagerId()){	
			Employee existingManager=employeeRepository.getEmpByEmpId(e.getManagerId());
			if(null!=existingManager){
				employee.setManager(existingManager);						
			}
			else{
				Employee manager =new Employee();
				manager.setEmpId(e.getManagerId());			
				employee.setManager(manager);
				employeeRepository.save(manager);
			}
		}
		employeeRepository.save(employee);				

	}

	public Employee getEmployeeHirerachy(Integer empId){

		return employeeRepository.getEmpByEmpId(empId);


	}
	
	public List<Employee> getTopTenEmployeesBySalary(){

		return employeeRepository.getTopTenEmployeesBySalary();

	}
	public void  deleteEmployee(Integer empId ){

		
		Employee employee=employeeRepository.getEmpByEmpId(empId);
		if(null!=employee){
			
			employee.setLastDate(new Date());
			
			employee.setStatus("Resigned");
			Set<Employee> reportees=employee.getReportees();
			if(null!=reportees&&!reportees.isEmpty()){
				
				for(Employee reportee:reportees){
					
					reportee.setManager(employee.getManager());
					employeeRepository.save(reportee);
					
				}
				
			}
			employee.setManager(null);
			employeeRepository.save(employee);
			
			
		}
		

	}

}
