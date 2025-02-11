package com.suda.GoF23.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/19$
 */
public abstract class NumberGenerator {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        Iterator<Observer> iter = observers.iterator();
        while (iter.hasNext()) {
            Observer observer = iter.next();
            observer.update(this);
        }
    }

    public abstract int getNumber();
    public abstract void execute();
}
