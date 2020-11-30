package com.iliev.microservicestroughmessaging.publisher;

import com.iliev.microservicestroughmessaging.dto.Toll;
import com.iliev.microservicestroughmessaging.messagechanals.TollSource;
import java.util.Random;
import javax.annotation.processing.Processor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(TollSource.class)
//@EnableBinding(Processor.class)
public class TollPublisher {

//    @InboundChannelAdapter(channel = "fastPassTollChanel",poller = @Poller(fixedDelay = "2000"))
//    public String sendTollCharge() {
//        return "{station:\"20\", customerid:\"100\", timestamp: \"2017-07-12T03:15:00\"}";
//    }

    Random r = new Random();

    @Bean
    @InboundChannelAdapter(channel = "fastpassTollChannel", poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Toll> sendTollCharge() {
        //return "{station:\"20\", customerid:\"100\", timestamp: \"2017-07-12T03:15:00\"}";
        return () -> MessageBuilder.withPayload(new Toll("20", "100", "2017-07-12T03:15:00"))
            .setHeader("speed", r.nextInt(8) *10).build();
    }
}
