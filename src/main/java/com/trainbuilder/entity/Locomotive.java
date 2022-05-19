package com.trainbuilder.entity;


import com.trainbuilder.enums.EngineType;

import java.time.LocalDate;

public class Locomotive extends PartOfTrain{
    private Integer tractiveEffort;
    private EngineType engineType;

    public Locomotive(Integer emptyWeight, Float length, Integer numberOfPassengers, Integer maximumLoadingWeight, String typeOfDesignation, String manufacturer, LocalDate yearOfProduction, String serialNumber, Integer tractiveEffort, EngineType engineType) {
        super(emptyWeight, length, numberOfPassengers, maximumLoadingWeight, typeOfDesignation, manufacturer, yearOfProduction, serialNumber);
        this.tractiveEffort = tractiveEffort;
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                super.toString() +
                ", tractiveEffort=" + tractiveEffort +
                ", engineType=" + engineType +
                '}';
    }

    public Integer getTractiveEffort() {
        return tractiveEffort;
    }

    public void setTractiveEffort(Integer tractiveEffort) {
        this.tractiveEffort = tractiveEffort;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
