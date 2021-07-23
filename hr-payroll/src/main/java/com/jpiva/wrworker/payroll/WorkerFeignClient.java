package com.jpiva.wrworker.payroll;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpiva.wrworker.payroll.entities.Worker;



@Component
@FeignClient(name="hr-worker", url="localhost:8001", path="/workres")
public interface WorkerFeignClient {
	
	@GetMapping(value ="/{id}")
	ResponseEntity<Worker> findById(@PathVariable  Long id);

}
