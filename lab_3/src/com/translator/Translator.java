package com.translator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translator {
    private final Map<String, String> dictionary;
    private final List<String> sortedKeys;

    public Translator() {
        this.dictionary = new HashMap<String, String>();
        this.sortedKeys = new ArrayList<String>();
    }

    public boolean loadDictionary(String filePath) {
        dictionary.clear();
        sortedKeys.clear();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "UTF-8"))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                int separatorIndex = line.indexOf('|');
                if (separatorIndex == -1) {
                    System.err.println("Error: Invalid format at line " + lineNumber + ": " + line);
                    return false;
                }

                String word = line.substring(0, separatorIndex).trim().toLowerCase();
                String translation = line.substring(separatorIndex + 1).trim();

                if (word.isEmpty()) {
                    System.err.println("Error: Empty word at line " + lineNumber);
                    return false;
                }

                dictionary.put(word, translation);
                sortedKeys.add(word);
            }

            Collections.sort(sortedKeys, new Comparator<String>() {
                public int compare(String a, String b) {
                    return Integer.valueOf(b.length()).compareTo(a.length());
                }
            });
            return true;

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return false;
        }
    }

    public String translate(String text) {
        if (text == null || text.trim().isEmpty()) {
            return text;
        }

        String[] words = text.split("\\s+");
        List<String> result = new ArrayList<String>();

        int i = 0;
        while (i < words.length) {
            String translated = null;
            String longestMatch = null;

            for (String key : sortedKeys) {
                String[] keyWords = key.split("\\s+");
                if (i + keyWords.length <= words.length) {
                    boolean match = true;

                    for (int j = 0; j < keyWords.length; j++) {
                        if (!words[i + j].toLowerCase().equals(keyWords[j])) {
                            match = false;
                            break;
                        }
                    }

                    if (match) {
                        longestMatch = key;
                        break;
                    }
                }
            }

            if (longestMatch != null) {
                translated = dictionary.get(longestMatch);
                i += longestMatch.split("\\s+").length;
            } else {
                translated = words[i];
                i++;
            }

            result.add(translated);
        }

        return joinString(result, " ");
    }

    private String joinString(List<String> list, String delimiter) {
        if (list.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(delimiter);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public Map<String, String> getDictionary() {
        return Collections.unmodifiableMap(dictionary);
    }
}