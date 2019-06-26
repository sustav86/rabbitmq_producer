package com.sustav.rabbit.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sustav.rabbit.rabbitmqproducer.entity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Picture picture) {
        String json = "";
        try {
            json = objectMapper.writeValueAsString(picture);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        rabbitTemplate.convertAndSend("x.picture", picture.getType(), json);

    }

}
