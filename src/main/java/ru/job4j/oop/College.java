package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshmen petr = new Freshmen();
        Student student = petr;
        Object obj1 = student;
        Object obj2 = petr;
    }
}
