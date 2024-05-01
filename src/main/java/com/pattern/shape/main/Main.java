package com.pattern.shape.main;

import com.pattern.shape.exception.InvalidDataException;
import com.pattern.shape.factory.RectangleFactory;
import com.pattern.shape.factory.impl.RectangleFactoryImpl;
import com.pattern.shape.model.Rectangle;
import com.pattern.shape.model.Warehouse;
import com.pattern.shape.observer.impl.RectangleObserverImpl;

import java.util.List;

public class Main {
    private static final String FILE_PATH_CORRECT = "src/main/resources/rectangles.txt";

    public static void main(String[] args) throws InvalidDataException {
        RectangleFactory rectangleFactory = new RectangleFactoryImpl();
            List<Rectangle> rectangles = rectangleFactory.createRectangleFromFile(FILE_PATH_CORRECT);
            Warehouse warehouse = Warehouse.getInstance();
            for (Rectangle rectangle : rectangles) {
                RectangleObserverImpl updater = new RectangleObserverImpl();
                updater.update(rectangle);
            }
            System.out.println(warehouse);
    }
}