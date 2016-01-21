package com.dh.example.webtest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_details")
public class UserDetails {
	
@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username")
	String userName;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "enabled")
	boolean enabled;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	
	List<Authority> authority;
	

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
	

}

