package com.suda.GoF23.factory;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/21$
 * 建立一个线程安全的工厂类
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = IDCardFactory.getInstance();
        CountDownLatch cnt = new CountDownLatch(20);
        for (int i = 0; i < 20; i ++ ) {
            new Thread(() -> {
                cnt.countDown();
                try {
                    cnt.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                factory.create("小明");
            }).start();
        }
    }
}
