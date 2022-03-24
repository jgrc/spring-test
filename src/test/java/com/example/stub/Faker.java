package com.example.stub;

import java.util.Random;
import java.util.UUID;

public class Faker {
    private static final String CHAR_NUMBERS = "0123456789";
    private static final String CHAR_LETTERS = "abcdefghijklmnopqrstuwxyz";

    public static Integer integerBetween(Integer min, Integer max) {
        return new Random().nextInt(max - min) + min;
    }

    public static String slug() {
        return String.format(
                "%s%s",
                wordWith(CHAR_LETTERS, 1),
                wordWith(CHAR_LETTERS + CHAR_NUMBERS, integerBetween(5, 15))
        );
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String email() {
        return String.format(
                "%s@%s.%s",
                slug(),
                wordWith(CHAR_LETTERS, integerBetween(2, 8)),
                wordWith(CHAR_LETTERS, 2)
        );
    }

    private static String wordWith(String characters, Integer length) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            word.append(characters.charAt(integerBetween(0, characters.length() - 1)));
        }

        return word.toString();
    }
}
