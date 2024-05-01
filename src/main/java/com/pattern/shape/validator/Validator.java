package com.pattern.shape.validator;

import com.pattern.shape.model.Rectangle;

public class Validator {

    public static boolean isValidRectangle(Rectangle rectangle) {
        double a = rectangle.getA();
        double b = rectangle.getB();
        double c = rectangle.getC();
        double d = rectangle.getD();
        return a > 0 && b > 0 && c > 0 && d > 0 && a == c && b == d;
    }

    public static boolean isSquare(Rectangle rectangle) {
        double a = rectangle.getA();
        double b = rectangle.getB();
        return a == b;
    }
}