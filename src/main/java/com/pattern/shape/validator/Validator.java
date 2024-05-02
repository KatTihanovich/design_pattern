package com.pattern.shape.validator;

import com.pattern.shape.exception.InvalidDataException;
import com.pattern.shape.model.Rectangle;

public class Validator {
    private static final String ERROR_MESSAGE = "Invalid data, rectangle can't be created";

    public static boolean isValidRectangle(Rectangle rectangle) throws InvalidDataException {
        double a = rectangle.getA();
        double b = rectangle.getB();
        double c = rectangle.getC();
        double d = rectangle.getD();
        if (a > 0 && b > 0 && c > 0 && d > 0 && a == c && b == d) {
            return true;
        } else {
            throw new InvalidDataException(ERROR_MESSAGE);
        }
    }

    public static boolean isSquare(Rectangle rectangle) {
        double a = rectangle.getA();
        double b = rectangle.getB();
        return a == b;
    }
}