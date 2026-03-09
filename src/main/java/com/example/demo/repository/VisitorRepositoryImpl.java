package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class VisitorRepositoryImpl implements VisitorRepository {

    private static final int MAX_VISITORS = 5;

    private final List<String> visitors = new ArrayList<>();

    @Override
    public void saveVisitor(String name) {

        visitors.add(name);

        while (visitors.size() > MAX_VISITORS) {
            visitors.remove(0);
        }
    }

    @Override
    public List<String> getRecentVisitors() {
        return new ArrayList<>(visitors);
    }
}