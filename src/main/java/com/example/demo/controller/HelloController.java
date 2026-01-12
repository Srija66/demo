package com.example.demo.controller;

import com.example.demo.dto.HelloRequest;
import com.example.demo.dto.HelloResponse;
import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;
    //Dependency Injection (Constructor-based)
    public HelloController(HelloService helloService){
        this.helloService=helloService;
    }

    @PostMapping
    public HelloResponse hello(@RequestBody HelloRequest request) {
        return helloService.buildGreeting(request.getName());
    }
}
