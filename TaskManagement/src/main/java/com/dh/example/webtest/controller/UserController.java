package com.dh.example.webtest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.example.webtest.model.Comment;
import com.dh.example.webtest.model.History;
import com.dh.example.webtest.model.Task;
import com.dh.example.webtest.model.User;
import com.dh.example.webtest.repositories.CommentRepository;
import com.dh.example.webtest.repositories.TaskRepository;
import com.dh.example.webtest.repositories.UserRepository;


@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	CommentRepository commentRepository;
	
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}	
	
	
	@RequestMapping("/tasks")
	public List<Task> getTasks() {
		return (List<Task>) taskRepository.findAll();
	}	
	
	@RequestMapping("/comments")
	public List<Comment> getComments() {
		return (List<Comment>) commentRepository.findAll();
	}

	@RequestMapping("/users/{userId}")
	public User getUsers(@PathVariable("userId") int userId) {
		return  userRepository.findOne(userId);
	}
	@RequestMapping("/tasks/{taskId}")
	public Task getTasks(@PathVariable("taskId") int taskId) {
		return  taskRepository.findOne(taskId);
	}
	@RequestMapping("/comments/{commentId}")
	public Comment getComments(@PathVariable("commentId") int commentId) {
		return  commentRepository.findOne(commentId);
	}

	
	
/*	@RequestMapping("/saveuser")
	public HashMap<String, Object> saveUser(@RequestBody User user) {
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		
		try {
			userRepository.save(user);
			returnParams.put("status", true);
		} catch (Exception e) {
			returnParams.put("status", false);
			returnParams.put("msg", "user Addition Failed");
		}

		return returnParams;
	}*/
	
	
	@RequestMapping("/savecomment")
	public HashMap<String, Object> saveComment(@RequestBody Comment comment) {
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		
		try {
			commentRepository.save(comment);
			returnParams.put("status", true);
		} catch (Exception e) {
			returnParams.put("status", false);
			returnParams.put("msg", "Comment Addition Failed!!!!!!");
		}

		return returnParams;
	}
	
	@RequestMapping("/edittask")
	public HashMap<String, Object> editTask(@RequestBody Task task) {
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		
		try {
			//System.out.println("Into Edit task !!");
			taskRepository.save(task);
			TaskRepository.tasklist.add(task);
			//System.out.println("Task edited successfully !!");

			//taskRepository.save(task);
			returnParams.put("status", true);
		} catch (Exception e) {
			returnParams.put("status", false);
			returnParams.put("msg", "Task Edit Failed!!!!!!");
		}

		return returnParams;
	}
	
	@RequestMapping("/savetask")
	public HashMap<String, Object> saveTask(@RequestBody Task task) {
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		
		try {
			
			
//			User user=getUser();
//			task.setUser(user);

			taskRepository.save(task);
			TaskRepository.tasklist.add(task);
			//taskRepository.save(task);
			returnParams.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			returnParams.put("status", false);
			returnParams.put("msg", "Task Addition Failed");
		}

		return returnParams;
	}
	
	

	
	/*@RequestMapping("/admin/savecustomeralt")
	public HashMap<String, Object> saveCustomer(@RequestBody HashMap<String, Object> params) {
		HashMap<String, Object> returnParams = new HashMap<String, Object>();
		
		try {
			
			returnParams.put("status", true);
		} catch (Exception e) {
			returnParams.put("status", false);
			returnParams.put("msg", "Customer Addition Failed");
		}

		return returnParams;
	}*/
	
	
	
	
	@RequestMapping("/public/gethistory/{taskId}")
	public List<Task> getHistory(@PathVariable("taskId") int taskId){
		List<Task> tasklist1= new ArrayList<Task>();
		System.out.println("entered into get history");

		for(int i=0;i<TaskRepository.tasklist.size();i++)
		{
			System.out.println("entered into for loop");
			Task task=TaskRepository.tasklist.get(i);
			if(taskId==task.getTaskId())
			{
				System.out.println("entered into if loop");
				tasklist1.add(task);
			}


		}


		return (List<Task>) tasklist1;
	}
	
	
	
	private User getUser(){
		String uName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByUserName(uName);
	}
	
	
	
	@RequestMapping("/posthistory")
	public HashMap<String,Object> postHistory(@RequestBody Task task){
		
		
			HashMap<String, Object> returnParams = new HashMap<String, Object>();
			
			try {
				
				List<History> hist = task.getHistory();

				Iterator<History> it = hist.iterator();
				
				while (it.hasNext()) {
					History hist1 = (History) it.next();
					System.out.println(hist1.getUserName());	
						hist1.setTask(task);
				}
		
			User user=task.getUser();
			System.out.println(user.getUserName());
			task.setUser(user);
			taskRepository.save(task);
				returnParams.put("status", true);
			} catch (Exception e) {
				e.printStackTrace();
				returnParams.put("status", false);
				returnParams.put("msg", "Customer Addition Failed");
			}

			return returnParams;
	}
	
	
	public Task getTask(@PathVariable("taskId") int taskId)
	{
		Task tasks=null;
		Task task= taskRepository.findOne(taskId);
		User user = getUser();
	if(	task.getUser()==user)
	{
		 tasks= task;
	}
	 return tasks;
	}	
	


		
	}

