package com.example.streams;

import java.util.*;

public class ExampleUsage {
    public static void main(String[] args) {
        System.out.println("=== STREAM API METHODS DEMO ===");

        // 1. Среднее значение
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        StreamApiMethods.average(numbers1).ifPresent(avg ->
                System.out.println("1. Average: " + avg)
        );

        // 2. Префикс + верхний регистр
        List<String> strings = Arrays.asList("hello", "world", "java");
        List<String> prefixed = StreamApiMethods.addPrefixToUpperCase(strings);
        System.out.println("2. With prefix: " + prefixed);

        // 3. Квадраты уникальных элементов
        List<Integer> numbers3 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueSquares = StreamApiMethods.squaresOfUnique(numbers3);
        System.out.println("3. Squares of unique: " + uniqueSquares);

        // 4. Последний элемент
        List<String> testList = Arrays.asList("a", "b", "c");
        String last = StreamApiMethods.getLastElement(testList);
        System.out.println("4. Last element: " + last);

        // 5. Сумма чётных чисел
        int[] numbers5 = {1, 2, 3, 4, 5, 6};
        int evenSum = StreamApiMethods.sumEvenNumbers(numbers5);
        System.out.println("5. Sum of even: " + evenSum);

        // 6. Строки в Map
        List<String> strings6 = Arrays.asList("apple", "banana", "cherry");
        Map<Character, String> resultMap = StreamApiMethods.stringsToMap(strings6);
        System.out.println("6. Strings to map: " + resultMap);

        // Тест исключения
        try {
            StreamApiMethods.getLastElement(new ArrayList<String>());
        } catch (NoSuchElementException e) {
            System.out.println("7. Exception caught: " + e.getMessage());
        }
    }
}