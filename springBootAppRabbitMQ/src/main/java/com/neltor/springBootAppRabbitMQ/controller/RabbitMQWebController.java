package com.neltor.springBootAppRabbitMQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neltor.springBootAppRabbitMQ.models.Employee;
import com.neltor.springBootAppRabbitMQ.services.RabbitMQSender;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQWebController {

	
	@Autowired
	RabbitMQSender rabbitSender;
	
	@GetMapping("/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId ) {
		
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		
		rabbitSender.send(emp);
		
		return "Message sent to the RabbiMQ Successfully.";
	}
	
}
