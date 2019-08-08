package com.bank.auth.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.auth.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	public Role findByRoleDesc(String roleDesc);
	
	//public Optional<Role> findById(Long id);
	
}
