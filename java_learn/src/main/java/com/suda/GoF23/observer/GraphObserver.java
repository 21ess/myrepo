package com.suda.GoF23.observer;

import java.util.concurrent.TimeUnit;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/19$
 */
public class GraphObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < generator.getNumber(); i ++ ) {
            stringBuffer.append("*");
        }
        System.out.println("GraphObserver: " + stringBuffer);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
