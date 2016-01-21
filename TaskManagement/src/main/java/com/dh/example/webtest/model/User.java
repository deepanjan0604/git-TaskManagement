package com.dh.example.webtest.model;


import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	int userId;
	
	
	@Column(name="u_name")
	String uName;
	
	@Column(name="user_name")
	String userName;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
	List<Task> tasks;

	/*@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	Comment comment;


	public Comment getComment() {
		return comment;
	}

	public void setComments(Comment comment) {
		this.comment = comment;
	}*/
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.DETACH }, orphanRemoval = true)
	List<History> history;

	
	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public String toString() {
		String str = this.userId+ " " + this.uName + "\n";

		Iterator<Task> it = this.tasks.iterator();
		while (it.hasNext()) {
			Task tasks = (Task) it.next();
			str += tasks.taskId + " " + tasks.title +" "+tasks.msg+ "\n";// " "+shippingAddress.customer_id+"\n";
		}

		return str;

	}

}

