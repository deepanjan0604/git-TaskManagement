package com.dh.example.webtest.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.example.webtest.model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
	public List<Task> tasklist= new ArrayList<Task>();

}