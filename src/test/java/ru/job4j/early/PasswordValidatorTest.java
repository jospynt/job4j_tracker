package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void whenNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Password should not be null.");
    }

    @Test
    void whenWrongLength() {
        String result = PasswordValidator.validate("psw");
        String expected = "Password length should be within 8 and 32.";
        assertEquals(result, expected);
    }

    @Test
    void whenIncludesSubstring() {
        String result = PasswordValidator.validate("T1$userT");
        String expected = "Password should not include substrings \"qwerty\", "
                + "\"12345\", \"password\", \"admin\", \"user\"";
        assertEquals(result, expected);
    }

    @Test
    void whenNoUpper() {
        String result = PasswordValidator.validate("t1$ttttt");
        String expected = "Password should include at least one upper case letter.";
        assertEquals(result, expected);
    }

    @Test
    void whenNoLower() {
        String result = PasswordValidator.validate("T1$TTTTT");
        String expected = "Password should include at least one lower case letter.";
        assertEquals(result, expected);
    }

    @Test
    void whenNoDigit() {
        String result = PasswordValidator.validate("Tt$ttttt");
        String expected = "Password should include at least one digit.";
        assertEquals(result, expected);
    }

    @Test
    void whenNoSpecial() {
        String result = PasswordValidator.validate("T1tttttt");
        String expected = "Password should include at least one special symbol.";
        assertEquals(result, expected);
    }

    @Test
    void whenCorrect() {
        String result = PasswordValidator.validate("T1$ttttt");
        String expected = "Password is correct.";
        assertEquals(result, expected);
    }
}