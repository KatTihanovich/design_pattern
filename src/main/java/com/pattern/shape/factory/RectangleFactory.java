package com.pattern.shape.factory;

import com.pattern.shape.model.Rectangle;

import java.util.List;

public interface RectangleFactory {
    List<Rectangle> createRectangle(Double[][] sides);

    List<Rectangle> createRectangleFromFile(String filePath);
}