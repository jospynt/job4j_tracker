package ru.job4j.poly;

public class DoubleDecker implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по улице.");
    }
}
