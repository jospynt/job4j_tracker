package ru.job4j.early;

public class PasswordValidator {
        public static String validate(String password) {
                if (password == null) {
                        throw new IllegalArgumentException("Password should not be null.");
                }
                if (password.length() < 8 || password.length() > 32) {
                        throw new IllegalArgumentException("Password length should be within 8 and 32.");
                }
                String[] checkWords = {"qwerty", "12345", "password", "admin", "user"};
                for (String word : checkWords) {
                        if (password.toLowerCase().contains(word)) {
                                throw new IllegalArgumentException("Password should not include substrings \"qwerty\", "
                                        + "\"12345\", \"password\", \"admin\", \"user\"");
                        }
                }
                char[] chars = password.toCharArray();
                boolean upperFlag = false;
                boolean digitFlag = false;
                boolean lowerFlag = false;
                boolean specialFlag = false;
                for (char c : chars) {
                        if (Character.isUpperCase(c)) {
                                upperFlag = true;
                        }
                        if (Character.isLowerCase(c)) {
                                lowerFlag = true;
                        }
                        if (Character.isDigit(c)) {
                                digitFlag = true;
                        }
                        if (!Character.isDigit(c) && !Character.isLetter(c)) {
                                specialFlag = true;
                        }
                        if (upperFlag && lowerFlag && digitFlag && specialFlag) {
                                break;
                        }
                }
                if (!upperFlag) {
                        throw new IllegalArgumentException("Password should include at least one upper case letter.");
                }
                if (!lowerFlag) {
                        throw new IllegalArgumentException("Password should include at least one lower case letter.");
                }
                if (!digitFlag) {
                        throw new IllegalArgumentException("Password should include at least one digit.");
                }
                if (!specialFlag) {
                        throw new IllegalArgumentException("Password should include at least one special symbol.");
                }
                return password;
        }
}
