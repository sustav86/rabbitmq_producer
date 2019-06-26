package com.sustav.rabbit.rabbitmqproducer;

import com.sustav.rabbit.rabbitmqproducer.entity.Employee;
import com.sustav.rabbit.rabbitmqproducer.entity.Picture;
import com.sustav.rabbit.rabbitmqproducer.producer.EmployeeJsonProducer;
import com.sustav.rabbit.rabbitmqproducer.producer.HelloRabbitProducer;
import com.sustav.rabbit.rabbitmqproducer.producer.HumanResProducer;
import com.sustav.rabbit.rabbitmqproducer.producer.PictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

    private final List<String> SOURCE = Arrays.asList("mobile", "web", "monolith");
    private final List<String> TYPE = Arrays.asList("jpg", "png", "svg");
    private final Random random = new Random();

//    @Autowired
//    private HelloRabbitProducer helloRabbitProducer;

//    @Autowired
//    private EmployeeJsonProducer employeeJsonProducer;

//    @Autowired
//    private HumanResProducer humanResProducer;

    @Autowired
    private PictureProducer pictureProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 6; i++) {
//            employeeJsonProducer.sendEmployee(new Employee(String.valueOf(i), "emp " + i, LocalDate.now()));
//        }
//        for (int i = 0; i < 6; i++) {
//            humanResProducer.sendEmployee(new Employee(String.valueOf(i), "emp " + i, LocalDate.now()));
//        }
        for (int i = 0; i < 6; i++) {
            pictureProducer.sendMessage(new Picture("name_" + i, TYPE.get(random.nextInt(3)), SOURCE.get(random.nextInt(3)), 100L * random.nextInt(3)));
        }
    }
}
