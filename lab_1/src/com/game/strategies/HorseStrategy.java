package com.game.strategies;

import com.game.hero.MoveStrategy;

public class HorseStrategy implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("The hero rides a horse from " + from + " to " + to);
    }

    @Override
    public String getDescription() {
        return "On a horse";
    }
}