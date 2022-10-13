package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condition) {
        String message = condition ? "Колобка съели :(" : "Колобок убежал.";
        System.out.println(message);
    }
}
