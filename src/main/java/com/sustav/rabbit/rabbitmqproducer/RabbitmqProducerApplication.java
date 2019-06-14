package com.sustav.rabbit.rabbitmqproducer;

import com.sustav.rabbit.rabbitmqproducer.entity.Employee;
import com.sustav.rabbit.rabbitmqproducer.producer.EmployeeJsonProducer;
import com.sustav.rabbit.rabbitmqproducer.producer.HelloRabbitProducer;
import com.sustav.rabbit.rabbitmqproducer.producer.HumanResProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

//    @Autowired
//    private HelloRabbitProducer helloRabbitProducer;

//    @Autowired
//    private EmployeeJsonProducer employeeJsonProducer;

    @Autowired
    private HumanResProducer humanResProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 6; i++) {
//            employeeJsonProducer.sendEmployee(new Employee(String.valueOf(i), "emp " + i, LocalDate.now()));
//        }
        for (int i = 0; i < 6; i++) {
            humanResProducer.sendEmployee(new Employee(String.valueOf(i), "emp " + i, LocalDate.now()));
        }
    }
}
