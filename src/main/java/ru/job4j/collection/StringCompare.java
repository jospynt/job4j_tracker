package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = left.length();
        int rsl;
        if (left.length() > right.length()) {
            minLength = right.length();
        }
        for (int i = 0; i < minLength; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return left.length() - right.length();
    }
}
