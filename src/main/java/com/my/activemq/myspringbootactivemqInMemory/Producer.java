package com.my.activemq.myspringbootactivemqInMemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/mq/publish")
public class Producer {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public String publishMessage(@PathVariable("message")final String message){
        jmsTemplate.convertAndSend(queue, message);
      return "Publish Successful";
    }


}
