package com.pattern.shape.observer;

import com.pattern.shape.model.Rectangle;

public interface RectangleObserver {
    void update(Rectangle rectangle);
}