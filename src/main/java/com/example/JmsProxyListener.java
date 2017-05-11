package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProxyListener {

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "inbound", containerFactory = "jmsListenerContainerFactory")
	public void receiveTodo(String message) {
		System.out.println(message);
		message = "proxy made some modification in : " +message;
		jmsTemplate.convertAndSend("outbound", message);
	}

}
