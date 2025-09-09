package com.game.strategies;

import com.game.hero.MoveStrategy;

public class WalkStrategy implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("The hero is walking from " + from + " to " + to);
    }

    @Override
    public String getDescription() {
        return "On foot";
    }
}