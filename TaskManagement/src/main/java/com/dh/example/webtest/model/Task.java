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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="taskId")
	int taskId;
	
	

	@Column
	String title;
	
	@Column
	String  msg;
	
	@Column
	String status;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	User user;
	
	@OneToMany(mappedBy = "task", fetch = FetchType.EAGER,  orphanRemoval = true)
	List<Comment> comment;
	

	@OneToMany(mappedBy = "task", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	List<History> history;
	

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}



	public List<Comment> getComment() {
		return comment;
	}


	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		String str = this.taskId+ " " + this.title +"\n";

		Iterator<Comment> it = this.comment.iterator();
		while (it.hasNext()) {
		Comment comments = (Comment) it.next();
			str += comments.commentId + " " + comments.comment +" "+ comments.uName +"\n";// " "+shippingAddress.customer_id+"\n";
		}

		return str;

	}



	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

      @JsonIgnore
	public User getUser() {
		return user;
	}

          @JsonProperty("user")
	public void setUser(User user) {
		this.user = user;
	}
 
      	public boolean isEdited() {
      		
      		
      		boolean edited;
			if ((SecurityContextHolder.getContext().getAuthentication().getName()).equalsIgnoreCase(this.user.userName))
      			edited= true;
      		else
      			edited=false;
      		return edited;
      	}
}
