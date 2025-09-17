package com.game.strategies;

import com.game.hero.MoveStrategy;

public class TeleportStrategy implements MoveStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Teleporting from " + from + " to " + to);
    }

    @Override
    public String getDescription() {
        return "Teleport";
    }
}