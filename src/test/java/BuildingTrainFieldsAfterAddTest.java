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

public class BuildingTrainFieldsAfterAddTest {

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
    }

    @Test
    public void emptyWeightTest() {
        Integer entireEmptyWeight = train.getEntireEmptyWeight();
        Integer sum = emptyWeight + emptyWeight1;
        Assertions.assertEquals(sum, entireEmptyWeight);
    }

    @Test
    public void lengthTest() {
        Float maxLength = train.getMaxLength();
        Float sum = length + length1;
        Assertions.assertEquals(sum, maxLength);
    }

    @Test
    public void numberOfPassengersTest() {
        Integer cal = train.getMaxNumberOfPassengers();
        Integer sum = numberOfPassengers + numberOfPassengers1;
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void maximumLoadingWeightForGoodsTest() {
        Integer cal = train.getMaxLoadingWeightForGoods();
        Integer sum = maximumLoadingWeight + maximumLoadingWeight1;
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void maximumLoadingWeighTest() {
        Integer cal = train.getMaxLoadingWeight();
        Integer sum = ((numberOfPassengers * 75) + maximumLoadingWeight) + ((numberOfPassengers1 * 75) + maximumLoadingWeight1);
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void tractiveEffortTest() {
        Integer cal = train.getUnusedTractiveEffort();
        Integer sum = tractiveEffort - (((numberOfPassengers * 75) + maximumLoadingWeight ) + ((numberOfPassengers1 * 75) + maximumLoadingWeight1 + emptyWeight1));
        Assertions.assertEquals(sum, cal);
    }

    @Test
    public void conductorsTest(){
        Integer cal = train.getAmountOfConductors();
        Integer sum = (int) Math.ceil( (float) (numberOfPassengers + numberOfPassengers1) / 50);
        Assertions.assertEquals(sum, cal);
    }
}
