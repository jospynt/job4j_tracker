package ru.job4j.poly;

public class TransportCompany {
    public static void main(String[] args) {
        Vehicle bus1 = new DoubleDecker();
        Vehicle jet1 = new Aircraft();
        Vehicle train1 = new Train();
        Vehicle bus2 = new DoubleDecker();
        Vehicle jet2 = new Aircraft();
        Vehicle train2 = new Train();

        Vehicle[] vehicles = {bus1, jet1, train1, bus2, jet2, train2};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
