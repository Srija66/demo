package com.example.demo.service;

import com.example.demo.dto.HelloResponse;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloService {
    private AtomicInteger counter = new AtomicInteger(0);
    private static final int MAX_VISITORS=5;

    private final List<String> Visitors=new ArrayList<>();
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

        Visitors.add(name);
        while(Visitors.size()> MAX_VISITORS){
            Visitors.remove(0);
        }
        List<String> recentVisitors=new ArrayList<>();
        for(String visitor:Visitors){
            recentVisitors.add(visitor);
        }
        return new HelloResponse(greeting, name, visit, recentVisitors);
    }

}
