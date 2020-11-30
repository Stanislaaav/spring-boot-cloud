package com.iliev.microservicestroughmessaging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Toll {

    public String stationId;
    public String custommerId;
    public String timestamp;
}
