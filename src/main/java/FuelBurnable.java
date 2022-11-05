package com.test;

public interface FuelBurnable {

    double getFuelLevel();

    double getFuelConsumptionSpeed();

    double burnFuel(double fuelLevel, double fuelConsumptionSpeed);
}
