import com.trainbuilder.entity.Locomotive;
import com.trainbuilder.entity.Train;
import com.trainbuilder.entity.Wagon;
import com.trainbuilder.enums.EngineType;
import com.trainbuilder.enums.TypeOfWagon;
import com.trainbuilder.factories.LocomotiveFactory;
import com.trainbuilder.factories.WagonFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BuildingTrainFieldsAfterComplexOperationsTest {

    private static final LocomotiveFactory locomotiveFactory = LocomotiveFactory.getFactoryInstance();
    private static final WagonFactory wagonFactory = WagonFactory.getFactoryInstance();

    private static Train train;

    private static Integer emptyWeight;
    private static Float length;
    private static Integer numberOfPassengers;
    private static Integer maximumLoadingWeight;
    private static Integer tractiveEffort;


    private static Integer emptyWeight1;
    private static Float length1;
    private static Integer numberOfPassengers1;
    private static Integer maximumLoadingWeight1;


    private static Integer emptyWeight2;
    private static Float length2;
    private static Integer numberOfPassengers2;
    private static Integer maximumLoadingWeight2;
    private static Integer tractiveEffort2;

    @BeforeAll
    public static void init() {

        emptyWeight = 15000;
        length = 24.5f;
        numberOfPassengers = 10;
        maximumLoadingWeight = 5000;
        tractiveEffort = 190000;

        train = new Train(new Locomotive(
                emptyWeight,
                length,
                numberOfPassengers,
                maximumLoadingWeight,
                "BASD",
                "Poland",
                LocalDate.of(2000, 1, 2),
                "DB1A",
                tractiveEffort,
                EngineType.DIESEL
        ));

        emptyWeight1 = 20000;
        length1 = 22.5f;
        numberOfPassengers1 = 70;
        maximumLoadingWeight1 = 12000;

        train.add(new Wagon(
                emptyWeight1,
                length1,
                numberOfPassengers1,
                maximumLoadingWeight1,
                "BASD1",
                "Poland1",
                LocalDate.of(2000, 1, 2),
                "DB1A1",
                TypeOfWagon.PASSENGERS_WAGON
        ), true);

        emptyWeight2 = 15000;
        length2 = 30.5f;
        numberOfPassengers2 = 15;
        maximumLoadingWeight2 = 5000;
        tractiveEffort2 = 190000;

        train.add(new Locomotive(
                emptyWeight2,
                length2,
                numberOfPassengers2,
                maximumLoadingWeight2,
                "BASD",
                "Poland",
                LocalDate.of(2000, 1, 2),
                "DB1A",
                tractiveEffort2,
                EngineType.DIESEL
        ), true);

        train.add(new Wagon(
                emptyWeight1,
                length1,
                numberOfPassengers1,
                maximumLoadingWeight1,
                "BASD1",
                "Poland1",
                LocalDate.of(2000, 1, 2),
                "DB1A1",
                TypeOfWagon.PASSENGERS_WAGON
        ), true);

        train.add(new Locomotive(
                emptyWeight2,
                length2,
                numberOfPassengers2,
                maximumLoadingWeight2,
                "BASD",
                "Poland",
                LocalDate.of(2000, 1, 2),
                "DB1A",
                tractiveEffort2,
                EngineType.DIESEL
        ), true);

        train.remove(train.size()-1);
        train.remove(train.size()-1);
    }

    @Test
    public void emptyWeightTest() {
        Integer entireEmptyWeight = train.getEntireEmptyWeight();
        Integer sum = emptyWeight + emptyWeight1 + emptyWeight2;
        Assertions.assertEquals(sum, entireEmptyWeight);
    }

    @Test
    public void lengthTest() {
        Float maxLength = train.getMaxLength();
        Float sum = length + length1 + length2;
        Assertions.assertEquals(sum, maxLength);
    }

    @Test
    public void numberOfPassengersTest() {
        Integer cal = train.getMaxNumberOfPassengers();
        Integer sum = numberOfPassengers + numberOfPassengers1 + numberOfPassengers2;
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void maximumLoadingWeightForGoodsTest() {
        Integer cal = train.getMaxLoadingWeightForGoods();
        Integer sum = maximumLoadingWeight + maximumLoadingWeight1 + maximumLoadingWeight2;
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void maximumLoadingWeighTest() {
        Integer cal = train.getMaxLoadingWeight();
        Integer sum = ((numberOfPassengers * 75) + maximumLoadingWeight) +
                ((numberOfPassengers1 * 75) + maximumLoadingWeight1) +
                ((numberOfPassengers2 * 75) + maximumLoadingWeight2);
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void tractiveEffortTest() {
        Integer cal = train.getUnusedTractiveEffort();
        Integer sum = (tractiveEffort + tractiveEffort2) - (
                ((numberOfPassengers * 75) + maximumLoadingWeight) +
                ((numberOfPassengers1 * 75) + maximumLoadingWeight1 + emptyWeight1) +
                ((numberOfPassengers2 * 75) + maximumLoadingWeight2)
        );
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void conductorsTest(){
        Integer cal = train.getAmountOfConductors();
        Integer sum = (int) Math.ceil( (float) (numberOfPassengers + numberOfPassengers1 + numberOfPassengers2) / 50);
        Assertions.assertEquals(sum, cal);
    }
}
