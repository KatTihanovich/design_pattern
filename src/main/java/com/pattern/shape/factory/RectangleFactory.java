package com.pattern.shape.factory;

import com.pattern.shape.exception.InvalidDataException;
import com.pattern.shape.model.Rectangle;

import java.util.List;

public interface RectangleFactory {
    List<Rectangle> createRectangle(Double[][] sides) throws InvalidDataException;

    List<Rectangle> createRectangleFromFile(String filePath) throws InvalidDataException;
}