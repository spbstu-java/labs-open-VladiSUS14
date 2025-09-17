package com.translator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Устанавливаем UTF-8 для вывода в консоль
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
            System.setErr(new java.io.PrintStream(System.err, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("UTF-8 not supported");
        }

        Scanner scanner = new Scanner(System.in, "UTF-8");
        Translator translator = new Translator();

        System.out.println("=== TRANSLATOR PROGRAM ===");
        System.out.print("Enter dictionary file path: ");
        String filePath = scanner.nextLine().trim();

        if (!translator.loadDictionary(filePath)) {
            System.out.println("Failed to load dictionary. Exiting.");
            scanner.close();
            return;
        }

        System.out.println("Dictionary loaded successfully!");
        System.out.println("Loaded " + translator.getDictionary().size() + " words");

        while (true) {
            System.out.println("\nEnter text to translate (or 'exit' to quit):");
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            String translation = translator.translate(input);
            System.out.println("Translation: " + translation);
        }

        scanner.close();
        System.out.println("Program finished.");
    }
}