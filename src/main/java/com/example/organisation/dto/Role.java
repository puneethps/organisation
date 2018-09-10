package com.example.organisation.dto;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;

	public int getRoleId() {
		return roleId;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "parent_role_id")
	@JsonIgnore
	private Role parentRole;
	
	
	@OneToOne(mappedBy = "parentRole")
	private Role childRole;

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role getParentRole() {
		return parentRole;
	}

	public void setParentRole(Role parentRole) {
		this.parentRole = parentRole;
	}

	public Role getChildRole() {
		return childRole;
	}

	public void setChildRole(Role childRole) {
		this.childRole = childRole;
	}
	
}
