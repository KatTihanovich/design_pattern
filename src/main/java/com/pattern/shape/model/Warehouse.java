package com.pattern.shape.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private final HashMap<Integer, List<Double>> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public List<Double> get(Integer key) {
        return map.get(key);
    }

    public Double getPerimeter(Integer key) {
        return map.get(key).get(0);
    }

    public Double getSquare(Integer key) {
        return map.get(key).get(1);
    }

    public void put(Integer key, Double perimeter, Double square) {
        List<Double> values = new ArrayList<>();
        values.add(perimeter);
        values.add(square);
        map.put(key, values);
    }

    public void put(Integer key, List<Double> values) {
        map.put(key, values);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("rectangleDataMap=" + map)
                .toString();
    }
}