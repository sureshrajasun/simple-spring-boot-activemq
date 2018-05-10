package com.my.activemq.standalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;


@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {


    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") String message) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                jmsTemplate.convertAndSend(queue, message + ": " + i);
            }
        });
        t1.setName("First");

        Thread t2 = new Thread(() -> {
            for (int i = 200; i < 300; i++) {
                jmsTemplate.convertAndSend(queue, message + ": " + i + ": " + Thread.currentThread().getName());
            }
        });
        t2.setName("Second");

        Thread t3 = new Thread(() -> {
            for (int i = 300; i < 400; i++) {
                jmsTemplate.convertAndSend(queue, message + ": " + i + ": " + Thread.currentThread().getName());
            }
        });
        t3.setName("Third");
        Thread t4 = new Thread(() -> {
            for (int i = 400; i < 500; i++) {
                jmsTemplate.convertAndSend(queue, message + ": " + i + ": " + Thread.currentThread().getName());
            }
        });

        t4.setName("Fourth");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        return "Publish Successful!!";
    }


    @GetMapping("/")
    public String sendMessage() {
        jmsTemplate.convertAndSend(queue, "Test");
        return "Test Single!!";
    }

}
