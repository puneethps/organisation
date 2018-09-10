package com.example.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.organisation.dto.Role;

public interface RoleRepository  extends JpaRepository<Role	,Integer> {
	
	@Query("from Role where roleName=:roleName")
	Role getRoleByRoleName(@Param("roleName") String roleName);
	
	@Query("from Role where roleId=:roleId")
	Role getRoleByRoleId(@Param("roleId") Integer roleId);
	

}
