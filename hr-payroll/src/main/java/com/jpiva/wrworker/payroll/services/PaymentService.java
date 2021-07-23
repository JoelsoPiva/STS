package com.jpiva.wrworker.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpiva.wrworker.payroll.WorkerFeignClient;
import com.jpiva.wrworker.payroll.entities.Paymanent;
import com.jpiva.wrworker.payroll.entities.Worker;

@Service
public class PaymentService {
	
		
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
		public Paymanent getPayment (long workerId, int days) {
		
			
			Worker worker =  workerFeignClient.findById(workerId).getBody();
			return new Paymanent(worker.getName(), worker.getDailyInome(), days);
		}
}
