package com.game.hero;

public interface MoveStrategy {
    void move(String from, String to);
    String getDescription();
}