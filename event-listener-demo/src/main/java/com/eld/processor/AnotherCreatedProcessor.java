package com.eld.processor;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.eld.message.SomeMessage;

@Component
public class AnotherCreatedProcessor {

    @Order(1)
    @EventListener(condition = "#message.header.headerType == T(com.eld.message.HeaderTypes).CREATE")
    public void processCreateSomeMore(SomeMessage message) {
        System.out.println("Doing some more stuff for create");
    }
    
}
