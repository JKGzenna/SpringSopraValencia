package com.valencia.sopra.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="username", unique = true, nullable = false, length = 45)
	private String username;
	
	@Column(name="password", nullable = false, length = 60)
	private String passsword;
	
	@Column(name= "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public User(String username, String passsword, boolean enabled, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.passsword = passsword;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	public User(String username, String passsword, boolean enabled) {
		super();
		this.username = username;
		this.passsword = passsword;
		this.enabled = enabled;
	}
	public User() {}

}
