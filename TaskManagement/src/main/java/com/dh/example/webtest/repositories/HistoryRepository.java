package com.dh.example.webtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.example.webtest.model.History;


@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {


	
}
