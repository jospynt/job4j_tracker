package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double divide(int a) {
        return (double) a / x;
    }

    public double sumAllOperations(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(5));
        System.out.println(Calculator.minus(6));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(3));
        System.out.println(calculator.divide(6));
        System.out.println(calculator.sumAllOperations(1));
    }
}
