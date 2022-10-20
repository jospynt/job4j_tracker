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
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("psw");
                });
        assertThat(exception.getMessage()).isEqualTo("Password length should be within 8 and 32.");
    }

    @Test
    void whenIncludesSubstring() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("T1$userT");
                });
        assertThat(exception.getMessage()).isEqualTo("Password should not include substrings \"qwerty\", "
                + "\"12345\", \"password\", \"admin\", \"user\"");
    }

    @Test
    void whenNoUpper() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("t1$ttttt");
                });
        assertThat(exception.getMessage()).isEqualTo("Password should include at least one upper case letter.");
    }

    @Test
    void whenNoLower() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("T1$TTTTT");
                });
        assertThat(exception.getMessage()).isEqualTo("Password should include at least one lower case letter.");
    }

    @Test
    void whenNoDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("Tt$ttttt");
                });
        assertThat(exception.getMessage()).isEqualTo("Password should include at least one digit.");
    }

    @Test
    void whenNoSpecial() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("T1tttttt");
                });
        assertThat(exception.getMessage()).isEqualTo("Password should include at least one special symbol.");
    }

    @Test
    void whenCorrect() {
        String result = PasswordValidator.validate("T1$ttttt");
        String expected = "T1$ttttt";
        assertEquals(result, expected);
    }
}