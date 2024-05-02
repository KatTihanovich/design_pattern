package com.pattern.shape.factory.impl;

import com.pattern.shape.exception.InvalidDataException;
import com.pattern.shape.factory.RectangleFactory;
import com.pattern.shape.reader.FileReader;
import com.pattern.shape.model.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.pattern.shape.validator.Validator.isValidRectangle;

public class RectangleFactoryImpl implements RectangleFactory {
    private static final String ERROR_MESSAGE_SIDES = "Invalid data, rectangle requires 4 sides";
    private static final String ERROR_MESSAGE = "Invalid rectangle was generated";
    private static final Logger logger = LogManager.getLogger(RectangleFactoryImpl.class.getName());

    public List<Rectangle> createRectangle(Double[][] sides) {
        List<Rectangle> newRectangles = new ArrayList<>();

        for (Double[] current : sides) {
            try {
                double a = current[0];
                double b = current[1];
                double c = current[2];
                double d = current[3];
                Rectangle rectangle = new Rectangle(a, b, c, d);
                logger.info("Rectangle with id " + rectangle.getRectangleId() + " and sides:" + a + ", " + b + ", " + c + ", " + d + " is created");
                if (isValidRectangle(rectangle)) {
                    newRectangles.add(rectangle);
                } else {
                    logger.warn(ERROR_MESSAGE);
                }
            } catch (InvalidDataException e) {
                logger.warn(ERROR_MESSAGE_SIDES);
            }
        }
        return newRectangles;
    }

    public List<Rectangle> createRectangleFromFile(String filePath) {
        Double[][] sides = FileReader.readSides(filePath);
        return createRectangle(sides);
    }
}