package org.example.designPatterns.behavioral.ObservarDesignPattern.observables;

import org.example.designPatterns.behavioral.ObservarDesignPattern.observers.StockObserver;

public interface StockObservable {
    void addObserver(StockObserver stockObserver);
    void removeObserver(StockObserver stockObserver);
    void notifyObserver();
    void setStockCount(int stockCount);
}
