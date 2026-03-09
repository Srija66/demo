package com.example.demo.repository;

import java.util.List;

public interface VisitorRepository {
    void saveVisitor(String name);

    List<String> getRecentVisitors();
}
