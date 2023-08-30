package lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotTest {

    private ParkingSpot testObject;

    @BeforeEach
    public void setup() {
        testObject = new ParkingSpot(1);
    }

    @Test
    public void testGetSpotNumber() {
        int spotNumber = 1;
        int actual = testObject.getSpotNumber();
        assertEquals(spotNumber, actual);
    }

    @Test
    public void testIsOccupiedInitiallyFalse() {
        assertFalse(testObject.isOccupied());
    }

    @Test
    public void testOccupied() {
        testObject.occupy();
        testObject.vacate();
        assertTrue(testObject.isOccupied());
    }
    @Test
    public void testVacate() {
        testObject.occupy();
        testObject.vacate();
        assertTrue(testObject.isOccupied());
    }
}