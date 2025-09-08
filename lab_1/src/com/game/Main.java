package com.game;

import com.game.hero.Hero;
import com.game.strategies.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== COMPUTER GAME: STRATEGY PATTERN ===\n");

        Hero hero = new Hero("Vlad");
        System.out.println("Hero created: " + hero.getName());
        System.out.println("Initial movement: " + hero.getCurrentMoveStrategy() + "\n");

        String[] locations = {"Castle", "Forest", "Mountain", "Village", "Cave", "Lake"};

        demonstrateStrategies(hero, locations);

        System.out.println("\n=== GAME OVER ===");
    }

    private static void demonstrateStrategies(Hero hero, String[] locations) {
        System.out.println("1. " + hero.getCurrentMoveStrategy() + ":");
        hero.move(locations[0], locations[1]);

        hero.setMoveStrategy(new HorseStrategy());
        hero.move(locations[1], locations[2]);

        hero.setMoveStrategy(new FlyStrategy());
        hero.move(locations[2], locations[3]);

        hero.setMoveStrategy(new TeleportStrategy());
        hero.move(locations[3], locations[4]);

        hero.setMoveStrategy(new WalkStrategy());
        hero.move(locations[4], locations[5]);

        System.out.println("\n--- Dynamic strategy change demo ---");
        hero.setMoveStrategy(new HorseStrategy());
        hero.move(locations[5], locations[0]);

        hero.setMoveStrategy(new FlyStrategy());
        hero.move(locations[0], locations[2]);

        hero.setMoveStrategy(new TeleportStrategy());
        hero.move(locations[2], locations[4]);
    }
}