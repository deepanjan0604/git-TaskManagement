package com.dh.example.webtest.model;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


	@Entity
	@Table(name = "comments")
	public class Comment {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="commentId")
		int commentId;
		
		
		@Column(name="uName")
		String uName;
		
		
		@Column
		String comment;
		
		 
		 @ManyToOne(fetch = FetchType.EAGER)
		 @JsonIgnore
			Task task;
		 
		 
		/* @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL )
		 @JsonIgnore
		 User user;*/
		 

	
		public int getCommentId() {
			return commentId;
		}
		
		
		public void setCommentId(int commentId) {
			this.commentId = commentId;
		}
		
		
		public String getuName() {
			return uName;
		}

		public void setuName(String uName) {
			this.uName = uName;
		}

		



		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		/*public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}*/
			@JsonIgnore
		public Task getTask() {
			return task;
		}
			
		@JsonProperty("task")
		public void setTask(Task task) {
			this.task = task;
		}
	}
