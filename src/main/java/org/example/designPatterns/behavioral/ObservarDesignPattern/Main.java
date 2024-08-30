package org.example.designPatterns.behavioral.ObservarDesignPattern;

import org.example.designPatterns.behavioral.ObservarDesignPattern.observables.IphoneStockObservable;
import org.example.designPatterns.behavioral.ObservarDesignPattern.observables.StockObservable;
import org.example.designPatterns.behavioral.ObservarDesignPattern.observers.EmailNotificationObserverImpl;
import org.example.designPatterns.behavioral.ObservarDesignPattern.observers.MobileNotificationObserverImpl;
import org.example.designPatterns.behavioral.ObservarDesignPattern.observers.StockObserver;

public class Main {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneStockObservable();
        iphoneStockObservable.addObserver(new EmailNotificationObserverImpl("maheshp@gmail.com"));
        iphoneStockObservable.addObserver(new EmailNotificationObserverImpl("vinayakw@gmail.com"));
        StockObserver mobileNotificationObserver = new MobileNotificationObserverImpl("9876543210");
        iphoneStockObservable.addObserver(mobileNotificationObserver);

        iphoneStockObservable.setStockCount(100);

        System.out.println("Removing mobile observer");
        iphoneStockObservable.removeObserver(mobileNotificationObserver);

        iphoneStockObservable.setStockCount(100);
    }
}
