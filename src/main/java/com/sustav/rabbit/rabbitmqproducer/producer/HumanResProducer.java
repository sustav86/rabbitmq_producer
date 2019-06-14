package com.sustav.rabbit.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sustav.rabbit.rabbitmqproducer.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanResProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private Logger logger = LoggerFactory.getLogger(HumanResProducer.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendEmployee(Employee employee) {
        String emp = Employee.EMPTY_EMPLOYEE.toString();
        try {
            emp = objectMapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (Math.random() * 10 > 5) {
            rabbitTemplate.convertAndSend("x.hr", "q.hr.accounting", emp);
        } else {
            rabbitTemplate.convertAndSend("x.hr", "q.hr.marketing", emp);
        }
    }
}
