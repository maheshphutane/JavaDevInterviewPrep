package org.example.designPatterns.behavioral.ObservarDesignPattern.observables;

import org.example.designPatterns.behavioral.ObservarDesignPattern.observers.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{
    List<StockObserver> stockObserverList = new ArrayList<>();
    int stockCount=0;
    @Override
    public void addObserver(StockObserver stockObserver) {
        stockObserverList.add(stockObserver);
    }

    @Override
    public void removeObserver(StockObserver stockObserver) {
        stockObserverList.remove(stockObserver);
    }

    @Override
    public void notifyObserver() {
        for(StockObserver stockObserver:stockObserverList){
            stockObserver.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
        notifyObserver();
    }
}
