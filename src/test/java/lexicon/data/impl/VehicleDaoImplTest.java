package lexicon.data.impl;

import lexicon.model.Vehicle;
import lexicon.model.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDaoImplTest {

    private VehicleDaoImpl testObject;
    private Vehicle vehicle;

    @BeforeEach
    public void setup() {
        testObject = new VehicleDaoImpl();
        vehicle = new Vehicle("ABC123", VehicleType.CAR);
    }

    @Test
    public void testCreate() {
        Vehicle createdVehicle = testObject.create(vehicle);
        assertEquals(vehicle, createdVehicle);
    }

    @Test
    public void testCreateExistingVehicle() {
        Vehicle createdVehicle = testObject.create(vehicle);

        assertThrows(IllegalArgumentException.class,
                () -> testObject.create(vehicle)
        );
    }

    @Test
    public void testFindExistingVehicle() {
        testObject.create(vehicle);
        Optional<Vehicle> vehicleOptional = testObject.find("ABC123");
        assertTrue(vehicleOptional.isPresent());
    }
    @Test
    public void testFindNonExistingVehicle() {
        testObject.create(vehicle);
        Optional<Vehicle> vehicleOptional = testObject.find("DAB123");
        assertFalse(vehicleOptional.isPresent());
    }

    @Test
    public void testUpdate() {
        testObject.create(vehicle);

        Vehicle toUpdate = new Vehicle("ABC123", VehicleType.TRUCK);
        testObject.update(toUpdate);

        Optional<Vehicle> vehicleOptional = testObject.find("ABC123");
        assertTrue(vehicleOptional.isPresent());

        Vehicle vehicle = vehicleOptional.get();
        assertEquals(VehicleType.TRUCK, vehicle.getType());
    }
}