package com.example.demo;

import java.util.List;

public interface VisitorRepository {
    void saveVisitor(String name);

    List<String> getRecentVisitors();
}
