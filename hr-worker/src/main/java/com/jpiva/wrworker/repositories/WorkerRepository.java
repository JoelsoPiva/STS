package com.jpiva.wrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpiva.wrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>  {

}
