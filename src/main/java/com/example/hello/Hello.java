package com.example.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {

    private Logger logger;

    public Hello() {
        logger = LoggerFactory.getLogger(Hello.class);
    }
    
    public void sayHello() {
        logger.info("Hello!");
    }
}
