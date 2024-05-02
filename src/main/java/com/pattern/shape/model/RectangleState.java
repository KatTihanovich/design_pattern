package com.pattern.shape.model;

import com.pattern.shape.exception.InvalidDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.pattern.shape.validator.Validator.isSquare;
import static com.pattern.shape.validator.Validator.isValidRectangle;

public enum RectangleState {
    UNDEFINED, INVALID, REGULAR, SQUARE;

    private static final Logger logger = LogManager.getLogger(RectangleState.class.getName());
    private static final String DETECTING_MESSAGE = "Detecting rectangle with sides: ";

    private static final String SQUARE_MESSAGE = "Rectangle is classified as SQUARE";
    private static final String REGULAR_RECTANGLE_MESSAGE = "Rectangle is classified as REGULAR";
    private static final String INVALID_RECTANGLE_MESSAGE = "Rectangle is classified as INVALID";


    public static RectangleState detect(Rectangle rectangle) {
        logger.info(DETECTING_MESSAGE + rectangle.getA() + ", " + rectangle.getB() + ", " + rectangle.getC() + ", " + rectangle.getD());
        RectangleState state = UNDEFINED;
        try {
            if (isValidRectangle(rectangle)) {
                if (isSquare(rectangle)) {
                    logger.info(SQUARE_MESSAGE);
                    state = SQUARE;
                } else {
                    logger.info(REGULAR_RECTANGLE_MESSAGE);
                    state = REGULAR;
                }
            }
        } catch (InvalidDataException e) {
            logger.warn(INVALID_RECTANGLE_MESSAGE);
            state = INVALID;
        }
        return state;
    }
}