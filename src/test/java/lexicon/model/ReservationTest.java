package lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation testObject;

//    @BeforeEach
//    public void setup() {
//        testObject = new Reservation();
//    }

    @Test
    public void testConstructorWithoutId() {
        Customer customer = new Customer("Test", "123456)");
        ParkingSpot parkingSpot = new ParkingSpot(1);
        Vehicle vehicle = new Vehicle("abc123", VehicleType.CAR);
        testObject = new Reservation(LocalTime.parse("10.00"), LocalTime.parse("12:00"), customer, parkingSpot, vehicle);
    }

}