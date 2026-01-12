package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloService {
    private AtomicInteger counter = new AtomicInteger(0);
    public Map<String, Object> buildGreeting(String name) {
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

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("greeting", greeting);
        response.put("name", name);
        response.put("visitorNumber", visit);
        return response;
    }

}
