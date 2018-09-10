package com.example.organisation.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Employee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	@Id
	@Column(name="emp_id")
	private Integer empId;
	
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	private Integer salary;
	
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)	
	private Date joinDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	
	private Date lastDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	private Date dateOfBirth;
	
	@JsonView(com.example.organisation.views.View.SimpleEmployeeView.class)
	private Integer age;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	@JsonIgnore
	private Employee manager;
	
	@OneToMany(mappedBy = "manager")
	@JsonView(com.example.organisation.views.View.EmployeeHierarchyView.class)
	private Set<Employee> reportees;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Transient
	private Integer managerId;
	
	@Transient
	private Integer roleId;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getReportees() {
		return reportees;
	}

	public void setReportees(Set<Employee> reportees) {
		this.reportees = reportees;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	} 
	
	
	

}
