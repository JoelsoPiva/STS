package com.jpiva.wrworker.payroll.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpiva.wrworker.payroll.entities.Paymanent;
import com.jpiva.wrworker.payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value ="/Payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value ="/{workerId}/days/{days}")
	public ResponseEntity <Paymanent> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Paymanent payment  = service.getPayment(workerId, days );
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity <Paymanent> getPaymentAlternative(Long workerId, Integer days){
		Paymanent payment  = new Paymanent("Joelso",100.0, days );
		return ResponseEntity.ok(payment);
		}

}
