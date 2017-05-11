package com.example;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ApplicationConfig {

    @Bean
    public ConnectionFactory activeMqConnectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }
    
}
