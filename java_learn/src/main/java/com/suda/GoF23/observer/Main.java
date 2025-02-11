package com.suda.GoF23.observer;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/19$
 */
public class Main {
    public static void main(String[] args) {
        DigitObserver digitObserver = new DigitObserver();
        GraphObserver graphObserver = new GraphObserver();
        NumberGenerator generator = new RandomNumberGenerator(100);
        generator.addObserver(digitObserver);
        generator.addObserver(graphObserver);
        generator.execute();
    }
}
