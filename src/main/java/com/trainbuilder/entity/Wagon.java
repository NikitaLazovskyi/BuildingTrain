package com.trainbuilder.entity;


import com.trainbuilder.enums.TypeOfWagon;

import java.time.LocalDate;

public class Wagon extends PartOfTrain {
    private TypeOfWagon typeOfWagon;

    public Wagon(Integer emptyWeight, Float length, Integer numberOfPassengers, Integer maximumLoadingWeight, String typeOfDesignation, String manufacturer, LocalDate yearOfProduction, String serialNumber, TypeOfWagon typeOfWagon) {
        super(emptyWeight, length, numberOfPassengers, maximumLoadingWeight, typeOfDesignation, manufacturer, yearOfProduction, serialNumber);
        this.typeOfWagon = typeOfWagon;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                super.toString() +
                ", typeOfWagon=" + typeOfWagon +
                '}';
    }

    public TypeOfWagon getTypeOfWagon() {
        return typeOfWagon;
    }

    public void setTypeOfWagon(TypeOfWagon typeOfWagon) {
        this.typeOfWagon = typeOfWagon;
    }
}
