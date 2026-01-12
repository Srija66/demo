package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
@RestController
public class HelloController {

    private final HelloService helloService;
    //Dependency Injection (Constructor-based)
    public HelloController(HelloService helloService){
        this.helloService=helloService;
    }
    @GetMapping("/hello")
    public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "World") String name) {

        return helloService.buildGreeting(name);
    }
}
