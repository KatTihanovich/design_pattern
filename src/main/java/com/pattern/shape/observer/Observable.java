package com.pattern.shape.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}