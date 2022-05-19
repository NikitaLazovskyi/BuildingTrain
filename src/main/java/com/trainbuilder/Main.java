package com.trainbuilder;


import com.trainbuilder.entity.Train;
import com.trainbuilder.enums.LocomotiveTypeOfDesignation;
import com.trainbuilder.enums.WagonTypeOfDesignation;
import com.trainbuilder.factories.LocomotiveFactory;
import com.trainbuilder.factories.WagonFactory;

public class Main {
    public static void main(String[] args) {
        LocomotiveFactory locomotiveFactory = LocomotiveFactory.getFactoryInstance();
        WagonFactory wagonFactory = WagonFactory.getFactoryInstance();

        Train train = new Train(locomotiveFactory.createLocomotive(LocomotiveTypeOfDesignation.LOCL));
        for (int i = 0; i < 35; i++) {
            if (i == 16) {
                train.add(locomotiveFactory.createLocomotive(LocomotiveTypeOfDesignation.LOCL), true);
            } else {
                train.add(wagonFactory.createWagon(WagonTypeOfDesignation.WAG_P_POL), true);
            }
        }

        train.forEach(System.out::println);
        System.out.println(train);
        System.out.println(train.size());
    }
}
