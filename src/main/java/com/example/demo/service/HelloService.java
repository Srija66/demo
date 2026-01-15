package com.example.demo.service;

import com.example.demo.dto.HelloResponse;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloService {
    private AtomicInteger counter = new AtomicInteger(0);
    public HelloResponse buildGreeting(String name) {
        LocalTime time=LocalTime.now();
        String greeting;
        if (time.isBefore(LocalTime.NOON)) {
            greeting = "Good morning";
        } else if (time.isBefore(LocalTime.of(18, 0))) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }
        int visit=counter.incrementAndGet();

        return new HelloResponse(greeting, name, visit);
    }

}
