package com.bank.auth.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ROLE_TBL")
public class Role implements Serializable {

	private Integer roleId;
	private String roleDesc;
	private String active_flag;
	private Set<User> users = new HashSet<User>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
