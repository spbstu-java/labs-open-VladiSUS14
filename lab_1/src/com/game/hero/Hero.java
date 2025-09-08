package com.game.hero;

import com.game.strategies.*;

public class Hero {
    private String name;
    private MoveStrategy moveStrategy;

    public Hero(String name) {
        this.name = name;
        this.moveStrategy = new WalkStrategy();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        System.out.println(name + " it's moving now: " + moveStrategy.getDescription());
    }

    public void move(String from, String to) {
        System.out.print(name + ": ");
        moveStrategy.move(from, to);
    }

    public String getCurrentMoveStrategy() {
        return moveStrategy.getDescription();
    }

    public String getName() {
        return name;
    }
}