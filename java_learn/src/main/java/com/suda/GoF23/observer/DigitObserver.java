package com.suda.GoF23.observer;

import java.util.concurrent.TimeUnit;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/19$
 */
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNumber());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
