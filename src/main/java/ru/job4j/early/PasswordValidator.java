package ru.job4j.early;

public class PasswordValidator {
        public static String validate(String password) {
                if (password == null) {
                        throw new IllegalArgumentException("Password should not be null.");
                }
                if (password.length() < 8 || password.length() > 32) {
                        return "Password length should be within 8 and 32.";
                }
                String[] checkWords = {"qwerty", "12345", "password", "admin", "user"};
                for (String word : checkWords) {
                        if (password.toLowerCase().contains(word)) {
                                return "Password should not include substrings \"qwerty\", "
                                        + "\"12345\", \"password\", \"admin\", \"user\"";
                        }
                }
                char[] chars = password.toCharArray();
                boolean upperFlag = false;
                boolean digitFlag = false;
                boolean lowerFlag = false;
                boolean specialFlag = false;
                for (char c : chars) {
                        if (!upperFlag && Character.isUpperCase(c)) {
                                upperFlag = true;
                        }
                        if (!lowerFlag && Character.isLowerCase(c)) {
                                lowerFlag = true;
                        }
                        if (!digitFlag && Character.isDigit(c)) {
                                digitFlag = true;
                        }
                        if (!specialFlag && !Character.isDigit(c) && !Character.isLetter(c)) {
                                specialFlag = true;
                        }
                }
                if (!upperFlag) {
                        return "Password should include at least one upper case letter.";
                }
                if (!lowerFlag) {
                        return "Password should include at least one lower case letter.";
                }
                if (!digitFlag) {
                        return "Password should include at least one digit.";
                }
                if (!specialFlag) {
                        return "Password should include at least one special symbol.";
                }
                return "Password is correct.";
        }
}
