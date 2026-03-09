package com.example.demo.service;

import com.example.demo.VisitorRepository;
import com.example.demo.dto.HelloResponse;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloService {

    private final VisitorRepository repository;

    private AtomicInteger counter = new AtomicInteger(0);


    public HelloService(VisitorRepository repository) {
        this.repository = repository;
    }



    public HelloResponse buildGreeting(String name) {

        LocalTime time = LocalTime.now();
        String greeting;

        if (time.isBefore(LocalTime.NOON)) {
            greeting = "Good morning";
        } else if (time.isBefore(LocalTime.of(18, 0))) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }


        int visit = counter.incrementAndGet();

        repository.saveVisitor(name);

        List<String> recentVisitors = repository.getRecentVisitors();


        return new HelloResponse(greeting, name, visit, recentVisitors);
    }
}
