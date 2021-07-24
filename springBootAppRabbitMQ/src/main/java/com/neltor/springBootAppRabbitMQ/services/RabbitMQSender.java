package com.neltor.springBootAppRabbitMQ.services;



import java.util.logging.Logger;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.neltor.springBootAppRabbitMQ.models.Employee;

@Service
public class RabbitMQSender {
	
	
	private static final Logger LOGGER = Logger.getLogger(RabbitMQSender.class.getName());
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${config.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${config.rabbitmq.routingkey}")
	private String routingkey;
	
	
	public void send(Employee company) {
		rabbitTemplate.convertAndSend(exchange, routingkey, company);
		LOGGER.info("Send msg = "+ company);
	}
	
	

}
