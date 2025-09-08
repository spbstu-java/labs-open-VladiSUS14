package com.game.strategies;

import com.game.hero.MoveStrategy;

public class FlyStrategy implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("The hero flies through the air from " + from + " to " + to);
    }

    @Override
    public String getDescription() {
        return "Flight";
    }
}