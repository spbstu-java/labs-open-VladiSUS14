package com.game.strategies;

import com.game.hero.MoveStrategy;

public class FlyStrategy implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Flying from " + from + " to " + to);
    }

    @Override
    public String getDescription() {
        return "Flying";
    }
}