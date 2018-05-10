package com.my.activemq.standalone;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @JmsListener(destination = "standalone.queue")
    public  void consume(String message){
        System.out.println("Received Message : "+message);
    }
}
