package com.pattern.shape.observer.impl;

import com.pattern.shape.model.Rectangle;
import com.pattern.shape.model.Warehouse;
import com.pattern.shape.observer.RectangleObserver;
import com.pattern.shape.service.RectangleService;

public class RectangleObserverImpl implements RectangleObserver {
    @Override
    public void update(Rectangle rectangle) {
        RectangleService service = new RectangleService();
        double perimeter = service.perimeter(rectangle);
        double square = service.square(rectangle);
        int key = rectangle.getRectangleId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, perimeter, square);
    }
}