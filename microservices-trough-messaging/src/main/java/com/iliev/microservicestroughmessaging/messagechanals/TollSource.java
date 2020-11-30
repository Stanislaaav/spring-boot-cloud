package com.iliev.microservicestroughmessaging.messagechanals;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface TollSource {

    @Output("fastpassTollChannel")
    MessageChannel getUsualMessage();

    @Output("standartTollChanal")
    MessageChannel standartMessage();
}
