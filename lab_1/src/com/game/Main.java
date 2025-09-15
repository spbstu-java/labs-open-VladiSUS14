package com.game;

import com.game.hero.Hero;
import com.game.strategies.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = new Hero("Arthur");

        System.out.println("=== HERO MOVEMENT GAME ===");
        System.out.println("Hero: " + hero.getName());

        while (true) {
            System.out.println("\nCurrent movement: " + hero.getCurrentMove());
            System.out.println("Choose action:");
            System.out.println("1. Move to location");
            System.out.println("2. Change movement type");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice == 3) {
                System.out.println("Game over!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter start location: ");
                    String from = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String to = scanner.nextLine();
                    hero.move(from, to);
                    break;

                case 2:
                    System.out.println("Choose movement type:");
                    System.out.println("1. Walk");
                    System.out.println("2. Horse");
                    System.out.println("3. Fly");
                    System.out.println("4. Teleport");
                    System.out.print("Your choice: ");

                    int moveChoice = 0;
                    try {
                        moveChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Using default walking.");
                        hero.setMoveStrategy(new WalkStrategy());
                        break;
                    }

                    switch (moveChoice) {
                        case 1:
                            hero.setMoveStrategy(new WalkStrategy());
                            break;
                        case 2:
                            hero.setMoveStrategy(new HorseStrategy());
                            break;
                        case 3:
                            hero.setMoveStrategy(new FlyStrategy());
                            break;
                        case 4:
                            hero.setMoveStrategy(new TeleportStrategy());
                            break;
                        default:
                            System.out.println("Invalid choice! Using default walking.");
                            hero.setMoveStrategy(new WalkStrategy());
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}