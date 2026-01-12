package com.example.demo.dto;

public class HelloRequest {
    //@NotBlank(message = "Name must not be empty")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
