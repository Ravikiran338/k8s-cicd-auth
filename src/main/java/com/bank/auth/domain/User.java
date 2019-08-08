package com.bank.auth.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_LOGIN_INFO_TBL")
public class User implements Serializable {
	private Integer userLoginId;
	private String username;
	private String password;
	private String activeFlag;
	private Date lastModifiedDateTime;
	private Role roles;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATETIME", nullable = false, length = 23)
	public Date getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}
}
