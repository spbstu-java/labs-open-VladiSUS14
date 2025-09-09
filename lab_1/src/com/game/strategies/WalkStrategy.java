package com.game.strategies;

import com.game.hero.MoveStrategy;

public class WalkStrategy implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Walking from " + from + " to " + to);
    }

    @Override
    public String getDescription() {
        return "Walking";
    }
}