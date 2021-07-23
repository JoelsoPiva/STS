package com.jpiva.wrworker.payroll.services;

import org.springframework.stereotype.Service;

import com.jpiva.wrworker.payroll.entities.Paymanent;

@Service
public class PaymentService {

		public Paymanent getPayment (long workerId, int days) {
			return new Paymanent("Bob", 200.00, days);
		}
}
