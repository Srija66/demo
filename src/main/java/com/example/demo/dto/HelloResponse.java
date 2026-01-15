package com.example.demo.dto;

public class HelloResponse {
    private String greeting;
    private String name;
    private int visitorNumber;

    public HelloResponse(String greeting, String name, int visitorNumber) {
        this.greeting = greeting;
        this.name = name;
        this.visitorNumber = visitorNumber;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getName() {
        return name;
    }

    public int getVisitorNumber() {
        return visitorNumber;
    }
}
