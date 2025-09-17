package com.game.hero;

import com.game.strategies.WalkStrategy;

public class Hero {
    private String name;
    private MoveStrategy moveStrategy;

    public Hero(String name) {
        this.name = name;
        this.moveStrategy = new WalkStrategy(); // стратегия по умолчанию
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            System.out.println("Error: Strategy cannot be null! Using default walking.");
            this.moveStrategy = new WalkStrategy();
        } else {
            this.moveStrategy = moveStrategy;
        }
    }

    public void move(String from, String to) {
        System.out.print(name + ": ");
        moveStrategy.move(from, to);
    }

    public String getCurrentMove() {
        return moveStrategy.getDescription();
    }

    public String getName() {
        return name;
    }
}