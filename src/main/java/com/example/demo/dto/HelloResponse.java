package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class HelloResponse {
    private String greeting;
    private String name;
    private int visitorNumber;
    private List<String> visitorsList=new ArrayList<>();

    public HelloResponse(String greeting, String name, int visitorNumber, List<String> visitorsList) {
        this.greeting = greeting;
        this.name = name;
        this.visitorNumber = visitorNumber;
        this.visitorsList=visitorsList;
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

    public List<String> getVisitorsList(){
        return visitorsList;}
}
