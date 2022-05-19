package com.trainbuilder.entity;

import java.time.LocalDate;

public abstract class PartOfTrain {
    private Integer emptyWeight;
    private Float length;

    private Integer numberOfPassengers;
    private Integer maximumLoadingWeight;

    private String typeOfDesignation;
    private String manufacturer;
    private LocalDate yearOfProduction;
    private String serialNumber;

    public PartOfTrain(Integer emptyWeight, Float length, Integer numberOfPassengers, Integer maximumLoadingWeight, String typeOfDesignation, String manufacturer, LocalDate yearOfProduction, String serialNumber) {
        this.emptyWeight = emptyWeight;
        this.length = length;
        this.numberOfPassengers = numberOfPassengers;
        this.maximumLoadingWeight = maximumLoadingWeight;
        this.typeOfDesignation = typeOfDesignation;
        this.manufacturer = manufacturer;
        this.yearOfProduction = yearOfProduction;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "emptyWeight=" + emptyWeight +
                ", length=" + length +
                ", numberOfPassengers=" + numberOfPassengers +
                ", maximumLoadingWeight=" + maximumLoadingWeight +
                ", typeOfDesignation='" + typeOfDesignation + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", serialNumber='" + serialNumber + '\'';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(Integer emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Integer getMaximumLoadingWeight() {
        return maximumLoadingWeight;
    }

    public void setMaximumLoadingWeight(Integer maximumLoadingWeight) {
        this.maximumLoadingWeight = maximumLoadingWeight;
    }

    public String getTypeOfDesignation() {
        return typeOfDesignation;
    }

    public void setTypeOfDesignation(String typeOfDesignation) {
        this.typeOfDesignation = typeOfDesignation;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
