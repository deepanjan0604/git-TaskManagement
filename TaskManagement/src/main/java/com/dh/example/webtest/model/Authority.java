package com.dh.example.webtest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Authority {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne
	UserDetails users;
	
	@JsonIgnore
	@Column(name = "authority")
	String authority;
	
	public UserDetails getUsers() {
		return users;
	}

	public void setUsers(UserDetails users) {
		this.users = users;
	}

	
	@Column(name = "username")
	String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
