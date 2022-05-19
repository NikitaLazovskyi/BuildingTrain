package com.trainbuilder.factories;

import com.trainbuilder.entity.Wagon;
import com.trainbuilder.enums.TypeOfWagon;
import com.trainbuilder.enums.WagonTypeOfDesignation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class WagonFactory {

    private static WagonFactory factoryInstance;
    private static final Map<WagonTypeOfDesignation, Integer> wagonCounter = new HashMap<>();

    private WagonFactory() {
    }

    public static WagonFactory getFactoryInstance() {
        if (factoryInstance == null) {
            return new WagonFactory();
        } else {
            return factoryInstance;
        }
    }

    public Wagon createWagon(WagonTypeOfDesignation type) {
        Wagon wagon = null;
        switch (type) {
            case PRIMARY:
                wagon = configureLocomotive(
                        type,
                        5000,
                        20.05f,
                        30,
                        15000,
                        "Britain",
                        TypeOfWagon.PASSENGERS_WAGON,
                        "B"
                );
                break;
            case WAG_G_UK:
                wagon = configureLocomotive(
                        type,
                        10000,
                        17.55f,
                        0,
                        100000,
                        "Ukraine",
                        TypeOfWagon.GOODS_WAGON,
                        "UK"
                );
                break;
            case WAG_P_UK:
                wagon = configureLocomotive(
                        type,
                        15000,
                        25.55f,
                        60,
                        10000,
                        "Ukraine",
                        TypeOfWagon.PASSENGERS_WAGON,
                        "P"
                );
                break;
            case WAG_G_POL:
                wagon = configureLocomotive(
                        type,
                        15000,
                        25.55f,
                        0,
                        120000,
                        "Poland",
                        TypeOfWagon.GOODS_WAGON,
                        "P"
                );
                break;
            case WAG_P_POL:
                wagon = configureLocomotive(
                        type,
                        18000,
                        28.05f,
                        78,
                        12000,
                        "Poland",
                        TypeOfWagon.PASSENGERS_WAGON,
                        "P"
                );
                break;
            case WAG_D_UK:
                wagon = configureLocomotive(
                        type,
                        5000,
                        20.05f,
                        120,
                        5000,
                        "Ukraine",
                        TypeOfWagon.DINING_WAGON,
                        "U"
                );
                break;
            case WAG_S_UK:
                wagon = configureLocomotive(
                        type,
                        9000,
                        23.05f,
                        80,
                        7000,
                        "Ukraine",
                        TypeOfWagon.SLEEPING_WAGON,
                        "U"
                );
                break;
            case WAG_D_POL:
                wagon = configureLocomotive(
                        type,
                        8000,
                        25.05f,
                        138,
                        9000,
                        "Poland",
                        TypeOfWagon.DINING_WAGON,
                        "P"
                );
                break;
            case WAG_S_POL:
                wagon = configureLocomotive(
                        type,
                        10000,
                        29.35f,
                        92,
                        12000,
                        "Poland",
                        TypeOfWagon.SLEEPING_WAGON,
                        "P"
                );
                break;
        }
        return wagon;
    }

    private Wagon configureLocomotive(WagonTypeOfDesignation type, Integer emptyWeight, Float length, Integer numberOfPassengers, Integer maximumLoadingWeight, String manufacturer, TypeOfWagon typeOfWagon, String mod) {
        Wagon wagon;
        if (wagonCounter.containsKey(type)) {
            Integer integer = wagonCounter.get(type);
            wagonCounter.put(type, integer + 1);
        } else {
            wagonCounter.put(type, 1);
        }
        String serialNumber = type.name() + wagonCounter.get(type) + mod;

        wagon = new Wagon(
                emptyWeight,
                length,
                numberOfPassengers,
                maximumLoadingWeight,
                type.name(),
                manufacturer,
                LocalDate.now(),
                serialNumber,
                typeOfWagon);

        return wagon;
    }
}
