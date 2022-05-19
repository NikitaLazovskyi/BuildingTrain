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
        train.add(wagonFactory.createWagon(WagonTypeOfDesignation.WAG_D_UK), true);
        train.forEach(System.out::println);
        System.out.println(train + "\n" + train.size());
        System.out.println("============================");
//        train.remove(1);
//        train.forEach(System.out::println);
//        System.out.println(train + "\n" + train.size());
    }
}
