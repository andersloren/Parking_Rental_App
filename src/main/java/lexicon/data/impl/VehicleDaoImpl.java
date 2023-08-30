package lexicon.data.impl;

import lexicon.data.VehicleDao;
import lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {

    private List<Vehicle> storage = new ArrayList<>(); // [v1, v2, v3]

    public VehicleDaoImpl() {
        storage = new ArrayList<>();
    }

    @Override
    public Vehicle create(Vehicle data) {
        if (data == null) throw new IllegalArgumentException("Vehicle Data is null");
        if (find(data.getLicensePlate()).isPresent())
            throw new IllegalArgumentException("License Plate is already registered");
        storage.add(data);
        return data;
    }

    @Override
    public Optional<Vehicle> find(String licensePlate) {
        for (Vehicle element : storage) {
            if (element.getLicensePlate().equals(licensePlate)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(String licensePlate) {
        Optional<Vehicle> vehicleOptional = find(licensePlate);
        if (vehicleOptional.isEmpty()) {
            return false;
        } else {
            storage.remove(vehicleOptional.get());
            return true;
        }
    }

    @Override
    public Collection<Vehicle> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Vehicle toUpdate) { // v1 = abc123, CAR -> abc123, TRUCK
        // step1: check the method params (parameters)
        // step2: find vehicle by license plate (Original Data)
        // step3: if vehicle exist -> find index
        // step4: replace it in index

        if (toUpdate == null) throw new IllegalArgumentException("Vehicle Data is null");
        Optional<Vehicle> existingVechileOptional = find(toUpdate.getLicensePlate());
        if (existingVechileOptional.isEmpty()) throw new IllegalArgumentException("License Plate not found");
        Vehicle originalData = existingVechileOptional.get();
        int index = storage.indexOf(originalData);
        if (index == -1) throw new IllegalArgumentException("Existing vehicle not found in the storage");
        storage.set(index, toUpdate);
    }
}
