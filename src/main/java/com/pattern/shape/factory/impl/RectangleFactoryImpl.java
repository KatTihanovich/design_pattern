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
    private static final String ERROR_MESSAGE = "Invalid data, rectangle can't be created";
    private static final Logger logger = LogManager.getLogger(RectangleFactoryImpl.class.getName());

    public List<Rectangle> createRectangle(Double[][] sides) {
        List<Rectangle> newRectangles = new ArrayList<>();

        for (Double[] current : sides) {
            try {
                if (current.length != 4) {
                    logger.warn(ERROR_MESSAGE_SIDES);
                } else {
                    double a = current[0];
                    double b = current[1];
                    double c = current[2];
                    double d = current[3];
                    Rectangle rectangle = createRectangleWithValidation(a, b, c, d);
                    newRectangles.add(rectangle);
                }
            } catch (InvalidDataException e) {
                logger.warn(ERROR_MESSAGE);
            }
        }
        return newRectangles;
    }

    private Rectangle createRectangleWithValidation(double a, double b, double c, double d) throws InvalidDataException {
        Rectangle rectangle = new Rectangle(a, b, c, d);
        if (isValidRectangle(rectangle)) {
            logger.info("Rectangle with id " + rectangle.getRectangleId() + " and sides:" + a + ", " + b + ", " + c + ", " + d + " is created");
            return rectangle;
        } else {
            throw new InvalidDataException(ERROR_MESSAGE);
        }
    }

    public List<Rectangle> createRectangleFromFile(String filePath) throws InvalidDataException {
        Double[][] sides = FileReader.readSides(filePath);
        return createRectangle(sides);
    }
}