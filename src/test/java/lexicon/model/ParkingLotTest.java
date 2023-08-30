package lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot testObject;

    @BeforeEach
    public void setup() {
        Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
        parkingSpotMap.put(1, new ParkingSpot(1, true));
        parkingSpotMap.put(2, new ParkingSpot(2, false));
        parkingSpotMap.put(3, new ParkingSpot(3, true));

        testObject = new ParkingLot(123, parkingSpotMap);
        testObject.displayParkingSpot();
    }

    @Test
    public void testGetAreaCode() {
        int expectedAreaCode = 123;
        Assertions.assertEquals(expectedAreaCode, testObject.getAreaCode());
    }

    @Test
    public void testGetParkingSpotsSize3() {
        int expectedSize = 3;
        int actual = testObject.getAvailableParkingSpots().size();
        assertNotEquals(expectedSize, actual); //
    }

    @Test
    public void testGetParkingSpotsSize1() {
        int expectedSize = 1;
        int actual = testObject.getAvailableParkingSpots().size();
        assertEquals(expectedSize, actual);
    }

    @Test
    public void testGetParkingSpotBySpotId2() {
        ParkingSpot parkingSpot = testObject.getParkingSpotBySpotNumber(2);
        assertNotNull(parkingSpot);
    }
}