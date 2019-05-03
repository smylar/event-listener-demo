package com.eld.service;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.eld.message.Header;
import com.eld.message.HeaderTypes;
import com.eld.message.Message;
import com.eld.message.SomeMessage;

@Service
public class MessageService implements InitializingBean {
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    public void doSomething() {
        Message firstMessage = new SomeMessage(new Header(HeaderTypes.CREATE, "moo"), "cow");
        System.out.println("Processing first message");
        publisher.publishEvent(firstMessage);
        
        Message secondMessage = new SomeMessage(new Header(HeaderTypes.UPDATE, "moo"), "moo");
        System.out.println("Processing second message (should do nothing)");
        publisher.publishEvent(secondMessage);
        
        Message thirdMessage = new SomeMessage(new Header(HeaderTypes.UPDATE, "moo"), "cow");
        System.out.println("Processing third message");
        publisher.publishEvent(thirdMessage);
    
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Executors.newSingleThreadScheduledExecutor().schedule(() -> doSomething(), 2, TimeUnit.SECONDS);
    }

}
