package com.example.organisation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.organisation.dto.Role;
import com.example.organisation.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public Role getRoleHierarchy(String roleName){
		
		
		return roleRepository.getRoleByRoleName(roleName);
		
	} 

}
