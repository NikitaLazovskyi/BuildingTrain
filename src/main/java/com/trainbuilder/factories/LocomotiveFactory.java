package com.trainbuilder.factories;

import com.trainbuilder.entity.Locomotive;
import com.trainbuilder.enums.EngineType;
import com.trainbuilder.enums.LocomotiveTypeOfDesignation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LocomotiveFactory {

    private static LocomotiveFactory factoryInstance;
    private static final Map<LocomotiveTypeOfDesignation, Integer> locomotivesCounter = new HashMap<>();

    private LocomotiveFactory() {
    }

    public static LocomotiveFactory getFactoryInstance() {
        if (factoryInstance == null) {
            return new LocomotiveFactory();
        } else {
            return factoryInstance;
        }
    }

    public Locomotive createLocomotive(LocomotiveTypeOfDesignation type) {
        Locomotive locomotive = null;
        switch (type) {
            case PRIMARY:
                locomotive = configureLocomotive(
                        type,
                        22000,
                        12.41f,
                        2,
                        4000,
                        "Poland",
                        900000,
                        EngineType.DIESEL,
                        "S"
                );
                break;
            case LOCH:
                locomotive = configureLocomotive(
                        type,
                        40000,
                        15.76f,
                        10,
                        10000,
                        "Ukraine",
                        1200000,
                        EngineType.DIESEL,
                        "UK"
                );
                break;
            case LOCL:
                locomotive = configureLocomotive(
                        type,
                        15000,
                        10.41f,
                        0,
                        2000,
                        "Poland",
                        600000,
                        EngineType.STEAM,
                        "LS"
                );
                break;
            case LOCBC:
                locomotive = configureLocomotive(
                        type,
                        20000,
                        13.10f,
                        6,
                        15000,
                        "Ukraine",
                        900000,
                        EngineType.ELECTRIC,
                        "UK"
                );
                break;
            case LOCUE:
                break;
        }
        return locomotive;
    }

    private Locomotive configureLocomotive(LocomotiveTypeOfDesignation type, Integer emptyWeight, Float length, Integer numberOfPassengers, Integer maximumLoadingWeight, String manufacturer, Integer tractiveEffort, EngineType engineType, String mod) {
        Locomotive locomotive;
        if (locomotivesCounter.containsKey(type)) {
            Integer integer = locomotivesCounter.get(type);
            locomotivesCounter.put(type, integer + 1);
        } else {
            locomotivesCounter.put(type, 1);
        }
        String serialNumber = type.name() + locomotivesCounter.get(type) + mod;

        locomotive = new Locomotive(
                emptyWeight,
                length,
                numberOfPassengers,
                maximumLoadingWeight,
                type.name(),
                manufacturer,
                LocalDate.now(),
                serialNumber,
                tractiveEffort,
                engineType);

        return locomotive;
    }
}
