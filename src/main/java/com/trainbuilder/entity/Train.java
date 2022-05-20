package com.trainbuilder.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Train {
    private final List<PartOfTrain> train = new ArrayList<>();
    private Integer entireEmptyWeight;
    private Float maxLength;
    private Integer maxNumberOfPassengers;
    private Integer maxLoadingWeightForGoods;
    private Integer maxLoadingWeight;
    private Integer maxTotalWeight;

    private Integer totalTractiveEffort;
    private Integer unusedTractiveEffort;
    private Boolean drivingCapability;

    private Integer amountOfConductors;

    public Train(Locomotive locomotive) {
        train.add(locomotive);
        entireEmptyWeight = locomotive.getEmptyWeight();
        maxLength = locomotive.getLength();
        maxNumberOfPassengers = locomotive.getNumberOfPassengers();
        maxLoadingWeightForGoods = locomotive.getMaximumLoadingWeight();
        maxLoadingWeight = (maxNumberOfPassengers * 75) + maxLoadingWeightForGoods;
        maxTotalWeight = entireEmptyWeight + maxLoadingWeight;

        totalTractiveEffort = locomotive.getTractiveEffort();
        unusedTractiveEffort = totalTractiveEffort - (maxTotalWeight - locomotive.getEmptyWeight());
        drivingCapability = unusedTractiveEffort > 0;
        amountOfConductors = maxNumberOfPassengers / 50;
    }

    public PartOfTrain get(int index) {
        return train.get(index);
    }

    public Boolean add(PartOfTrain partOfTrain, boolean check) {
        Boolean res = true;
        if (check) {
            res = checkDriveCapability(partOfTrain);
            if (res) {
                add(partOfTrain);
            }
        } else {
            add(partOfTrain);
        }
        return res;
    }

    private void add(PartOfTrain partOfTrain) {
        train.add(partOfTrain);
        entireEmptyWeight += partOfTrain.getEmptyWeight();
        maxLength += partOfTrain.getLength();
        maxNumberOfPassengers += partOfTrain.getNumberOfPassengers();
        maxLoadingWeightForGoods += partOfTrain.getMaximumLoadingWeight();
        if (partOfTrain.getClass().equals(Locomotive.class)) {
            totalTractiveEffort += ((Locomotive) partOfTrain).getTractiveEffort();
        }
        //updating train fields
        calculate();
    }

    private Boolean checkDriveCapability(PartOfTrain partOfTrain) {
        if (partOfTrain.getClass().equals(Locomotive.class)) {
            return true;
        }
        Integer total = partOfTrain.getEmptyWeight() + (partOfTrain.getNumberOfPassengers() * 75) + partOfTrain.getMaximumLoadingWeight();
        return unusedTractiveEffort > total;
    }

    public PartOfTrain remove(int index) {
        PartOfTrain removed = train.remove(index);
        entireEmptyWeight -= removed.getEmptyWeight();
        maxLength -= removed.getLength();
        maxNumberOfPassengers -= removed.getNumberOfPassengers();
        maxLoadingWeightForGoods -= removed.getMaximumLoadingWeight();
        if (removed.getClass().equals(Locomotive.class)) {
            totalTractiveEffort -= ((Locomotive) removed).getTractiveEffort();
        }
        //updating train fields
        calculate();
        return removed;
    }

    public void calculate(){
        maxLoadingWeight = (maxNumberOfPassengers * 75) + maxLoadingWeightForGoods;
        maxTotalWeight = entireEmptyWeight + maxLoadingWeight;

        // By the condition we shouldn't add emptyWeight of locomotive because him tractiveEffort calculated with emptyWeight
        unusedTractiveEffort = totalTractiveEffort -
                (maxTotalWeight - train.stream().
                        filter(partOfTrain1 -> partOfTrain1.getClass().equals(Locomotive.class)).
                        mapToInt(PartOfTrain::getEmptyWeight).sum()
                );
        drivingCapability = unusedTractiveEffort > 0;
        amountOfConductors = (int) Math.ceil((float) maxNumberOfPassengers / 50);
    }

    public PartOfTrain remove(PartOfTrain partOfTrain) {
        return remove(train.indexOf(partOfTrain));
    }

    public PartOfTrain change(PartOfTrain partOfTrain) {
        return change(partOfTrain, train.indexOf(partOfTrain));
    }

    public PartOfTrain change(PartOfTrain futurePart, int previousPartIndex) {
        PartOfTrain deleted;
        if (previousPartIndex >= 0) {
            deleted = remove(previousPartIndex);
            add(futurePart);
        } else {
            deleted = null;
        }
        return deleted;
    }

    public void forEach(Consumer<? super PartOfTrain> action) {
        train.forEach(action);
    }

    @Override
    public String toString() {
        return "Train{" +
                "entireEmptyWeight=" + entireEmptyWeight +
                ", maxLength=" + maxLength +
                ", maxNumberOfPassengers=" + maxNumberOfPassengers +
                ", maxLoadingWeightForGoods=" + maxLoadingWeightForGoods +
                ", maxLoadingWeight=" + maxLoadingWeight +
                ", maxTotalWeight=" + maxTotalWeight +
                ", totalTractiveEffort=" + totalTractiveEffort +
                ", unusedTractiveEffort=" + unusedTractiveEffort +
                ", drivingCapability=" + drivingCapability +
                ", amountOfConductors=" + amountOfConductors +
                '}';
    }

    public Integer size() {
        return train.size();
    }

    public Integer getUnusedTractiveEffort() {
        return unusedTractiveEffort;
    }

    public Integer getEntireEmptyWeight() {
        return entireEmptyWeight;
    }

    public Float getMaxLength() {
        return maxLength;
    }

    public Integer getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public Integer getMaxLoadingWeightForGoods() {
        return maxLoadingWeightForGoods;
    }

    public Integer getMaxLoadingWeight() {
        return maxLoadingWeight;
    }

    public Integer getMaxTotalWeight() {
        return maxTotalWeight;
    }

    public Integer getTotalTractiveEffort() {
        return totalTractiveEffort;
    }

    public Boolean getDrivingCapability() {
        return drivingCapability;
    }

    public Integer getAmountOfConductors() {
        return amountOfConductors;
    }
}
