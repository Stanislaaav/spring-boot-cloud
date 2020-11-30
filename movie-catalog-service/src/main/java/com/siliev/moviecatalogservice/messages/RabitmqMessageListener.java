package com.siliev.moviecatalogservice.messages;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Sink.class)
public class RabitmqMessageListener {

    // consume and return message to the queue
//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
//    public String log(String msg) {
//        return msg;
//    }

    // consume message from the queue
//    @ServiceActivator(inputChannel = Sink.INPUT)
//    public void printStreamMeassage(String msg) {
//        System.out.println(msg);
//    }

    // consume message from the queue
    @StreamListener(target = Sink.INPUT, condition = "headers['speed'] > 40")
    public void logFast(String msg) {
        System.out.println("slow - " + msg);
    }

    // consume message from the queue
    @StreamListener(target = Sink.INPUT, condition = "headers['speed'] > 50")
    public void logSlow(String msg) {
        System.out.println("fast - " + msg);
    }

}
