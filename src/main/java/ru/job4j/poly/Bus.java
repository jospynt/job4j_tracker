package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void go() {
        System.out.println("Now we're going");
    }

    @Override
    public void passengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 40;
    }
}
