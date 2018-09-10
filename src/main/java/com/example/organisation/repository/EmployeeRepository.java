package com.example.organisation.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.example.organisation.dto.Employee;


@Repository
@Transactional
public class  EmployeeRepository  {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Employee getEmpByEmpId(Integer empId){
		Query query = entityManager.createQuery(
				"from Employee where empId=:empId and status=:status", Employee.class);
		query.setParameter("empId", empId);
		query.setParameter("status", "Active");
		if(query.getResultList().size()>0)
			return (Employee)query.getSingleResult();
		else
			return null;
		
	}
	
	
	public List<Employee> getTopTenEmployeesBySalary(){
		Query query =entityManager.createNativeQuery("select * from Employee where  status=:status order by salary desc", Employee.class);
		query.setParameter("status", "Active").setMaxResults(10);
		List<Employee> topTenSalariedList=query.getResultList();				

		return topTenSalariedList;
		
	}
	
	public void save(Employee e){
		
		entityManager.merge(e);
		
	}
}
