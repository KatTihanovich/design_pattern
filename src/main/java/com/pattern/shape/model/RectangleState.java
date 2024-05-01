package com.pattern.shape.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.pattern.shape.validator.Validator.isSquare;
import static com.pattern.shape.validator.Validator.isValidRectangle;

public enum RectangleState {
    INVALID, REGULAR, SQUARE;

    private static final Logger logger = LogManager.getLogger(RectangleState.class.getName());

    public static RectangleState detect(Rectangle rectangle) {
        logger.info("Detecting rectangle with sides: " + rectangle.getA() + ", " + rectangle.getB() + ", " + rectangle.getC() + ", " + rectangle.getD());
        if (isValidRectangle(rectangle)) {
            if (isSquare(rectangle)) {
                logger.info("Rectangle is classified as SQUARE");
                return SQUARE;
            } else {
                logger.info("Rectangle is classified as REGULAR");
                return REGULAR;
            }
        } else {
            logger.warn("Rectangle is classified as INVALID");
            return INVALID;
        }
    }
}