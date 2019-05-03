package com.eld.processor;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.eld.message.SomeMessage;

@Component
public class CreatedProcessor {
    
    @EventListener(condition = "#message.header.headerType == T(com.eld.message.HeaderTypes).CREATE")
    @Order(0)
    public void processCreate(SomeMessage message) {
        System.out.println("Doing something for create");
    }
}
