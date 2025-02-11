package com.suda.GoF23.observer;

import java.util.Random;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/19$
 */
public class RandomNumberGenerator extends NumberGenerator{
    private Random random = new Random();
    private int number;

    public RandomNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i ++ ) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
