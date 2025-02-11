package com.suda.jvm.heap;

import java.util.concurrent.TimeUnit;

/**
 * @author alien
 * @program myrepo
 * @description 堆内存分配
 * @date 2024/11/18$
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            TimeUnit.MINUTES.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }

}