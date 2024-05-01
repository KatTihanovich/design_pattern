package com.pattern.shape.service;

import com.pattern.shape.model.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleService {
    private static final Logger logger = LogManager.getLogger(RectangleService.class.getName());

    public double perimeter(Rectangle rectangle) {
        double perimeter = (rectangle.getA() + rectangle.getB()) * 2;
        logger.info("Perimeter of rectangle with id " + rectangle.getRectangleId() + " is calculated and is equal to " + perimeter);
        return perimeter;
    }

    public double square(Rectangle rectangle) {
        double square = rectangle.getA() * rectangle.getB();
        logger.info("Square of rectangle with id " + rectangle.getRectangleId() + " is calculated and is equal to " + square);
        return square;
    }
}