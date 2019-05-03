package com.eld.processor;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.eld.message.SomeMessage;

@Component
public class UpdateProcessor {

    @EventListener(condition = "#message.header.headerType == T(com.eld.message.HeaderTypes).UPDATE "
                                + "&& #message.somethingSpecific == 'cow'")
    public void process(SomeMessage message) {
        System.out.println("Doing something for updated cow");
    }
}
