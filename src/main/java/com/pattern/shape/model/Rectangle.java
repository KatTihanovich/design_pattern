package com.pattern.shape.model;

import com.pattern.shape.util.IdGenerator;
import com.pattern.shape.observer.Observable;
import com.pattern.shape.observer.RectangleObserver;
import com.pattern.shape.observer.impl.RectangleObserverImpl;

import java.util.Objects;

public class Rectangle implements Observable {
    private RectangleObserver observer = new RectangleObserverImpl();
    private final int rectangleId;

    private double a;
    private double b;
    private double c;
    private double d;
    private RectangleState rectangleState;

    public Rectangle() {
        this.rectangleId = IdGenerator.increment();
    }

    public Rectangle(double a, double b, double c, double d) {
        this.rectangleId = IdGenerator.increment();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.rectangleState = RectangleState.detect(this);
    }

    public int getRectangleId() {
        return rectangleId;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public RectangleState getRectangleState() {
        return rectangleState;
    }

    public void setRectangleState(RectangleState rectangleState) {
        this.rectangleState = rectangleState;
    }

    @Override
    public void attach() {
        observer = new RectangleObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return getRectangleId() == rectangle.getRectangleId() && Double.compare(getA(), rectangle.getA()) == 0 && Double.compare(getB(), rectangle.getB()) == 0 && Double.compare(getC(), rectangle.getC()) == 0 && Double.compare(getD(), rectangle.getD()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRectangleId(), getA(), getB(), getC(), getD());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "rectangleId=" + rectangleId +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}