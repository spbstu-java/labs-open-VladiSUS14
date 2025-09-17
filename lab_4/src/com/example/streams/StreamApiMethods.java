package com.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiMethods {

    // 1. Метод, возвращающий среднее значение списка целых чисел
    public static OptionalDouble average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    // 2. Метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»
    public static List<String> addPrefixToUpperCase(List<String> strings) {
        return strings.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .collect(Collectors.toList());
    }

    // 3. Метод, возвращающий список квадратов всех встречающихся только один раз элементов списка
    public static List<Integer> squaresOfUnique(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey() * entry.getKey())
                .collect(Collectors.toList());
    }

    // 4. Метод, возвращающий последний элемент коллекции или кидающий исключение
    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    // 5. Метод, возвращающий сумму чётных чисел массива
    public static int sumEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    // 6. Метод, преобразовывающий строки в Map (первый символ – ключ, оставшиеся – значение)
    public static Map<Character, String> stringsToMap(List<String> strings) {
        return strings.stream()
                .filter(str -> str != null && !str.isEmpty())
                .collect(Collectors.toMap(
                        str -> str.charAt(0),
                        str -> str.length() > 1 ? str.substring(1) : "",
                        (existing, replacement) -> existing
                ));
    }
}